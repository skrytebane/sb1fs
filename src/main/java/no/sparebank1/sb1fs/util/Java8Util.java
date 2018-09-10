package no.sparebank1.sb1fs.util;


import java.util.concurrent.Callable;

public class Java8Util {
    public static interface ExceptionWrapper<E> {
        E wrap(Exception e);
    }

    public static <T> T propagate(Callable<T> callable) throws RuntimeException {
        return propagate(callable, RuntimeException::new);
    }

    public static <T, E extends Throwable> T propagate(Callable<T> callable, ExceptionWrapper<E> wrapper) throws E {
        try {
            return callable.call();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            throw wrapper.wrap(e);
        }
    }

    public interface RunnableWithException {
        public void run() throws Exception;
    }

    public static void consumer(RunnableWithException runnable) throws RuntimeException {
        consumer(runnable, RuntimeException::new);
    }

    public static void consumer(RunnableWithException runnable, ExceptionWrapper<RuntimeException> wrapper) {
        try {
            runnable.run();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            throw wrapper.wrap(e);
        }
    }
}