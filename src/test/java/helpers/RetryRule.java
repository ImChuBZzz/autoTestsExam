package helpers;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import java.util.Objects;


public class RetryRule implements TestRule {
    private final int retryCount;

    public RetryRule(int retryCount) {
        this.retryCount = retryCount;
    }

    public Statement apply (Statement base, Description description) {
        return statement(base, description);
    }

    private Statement statement(final  Statement base, final Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                Throwable caughtThrowable = null;
                for(int i = 0; i < retryCount; i++) {
                    try{
                        base.evaluate();
                        return;
                    } catch (Throwable t) {
                        caughtThrowable = t;
                        System.err.println(description.getDisplayName() + ": попытка №" + (i+1) + " без успеха");
                    }
                }
                System.err.println(description.getDisplayName() + ": не сработал после " + retryCount + " попыток");
                throw Objects.requireNonNull(caughtThrowable);
            }
        };
    }
}
