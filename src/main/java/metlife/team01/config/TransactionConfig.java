package metlife.team01.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;
import org.springframework.transaction.interceptor.RollbackRuleAttribute;
import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute;
import org.springframework.transaction.interceptor.TransactionInterceptor;

@Aspect
@Configuration
@EnableAspectJAutoProxy
public class TransactionConfig {
    private static final String AOP_POINTCUT_EXPRESSION = "execution(* metlife.team01..service..*(..))";
    @Autowired
    private PlatformTransactionManager transactionManager;

    public TransactionConfig() {
    }

    @Bean
    public TransactionInterceptor txAdvice() {
        TransactionInterceptor txAdvice = new TransactionInterceptor();
        List<RollbackRuleAttribute> rollbackRules = new ArrayList();
        rollbackRules.add(new RollbackRuleAttribute(Exception.class));
        DefaultTransactionAttribute attribute = new RuleBasedTransactionAttribute(0, rollbackRules);
        String transactionAttributesDefinition = attribute.toString();
        Properties txAttributes = new Properties();
        txAttributes.setProperty("insert*", transactionAttributesDefinition);
        txAttributes.setProperty("update*", transactionAttributesDefinition);
        txAttributes.setProperty("delete*", transactionAttributesDefinition);
        txAttributes.setProperty("useTx*", transactionAttributesDefinition);
        txAdvice.setTransactionAttributes(txAttributes);
        txAdvice.setTransactionManager(this.transactionManager);
        return txAdvice;
    }

    @Bean
    public Advisor txAdviceAdvisor() {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(* metlife.team01..service..*(..))");
        return new DefaultPointcutAdvisor(pointcut, this.txAdvice());
    }
}