package vertx.io.sqs;

import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import vertx.io.sqs.impl.SqsClientImpl;

import java.util.List;
import java.util.Map;

@VertxGen
public interface SqsClient {

    static SqsClient create(Vertx vertx, JsonObject config) {
        return new SqsClientImpl(vertx, config);
    }

    /**
     * Async result st a queue's URL.
     */
    void createQueue(String name, Map<String, String> attributes, Handler<AsyncResult<String>> resultHandler);

    /**
     * Async result is a list of queues' URLs. 'namePrefix' is nullable.
     */
    void listQueues(String namePrefix, Handler<AsyncResult<List<String>>> resultHandler);

    /**
     * Async result is a message's Id. 'delaySeconds' is nullable.
     */
    // TODO: add support for attributes
    void sendMessage(String queueUrl, String messageBody, Integer delaySeconds, Handler<AsyncResult<String>> resultHandler);


    void start(Handler<AsyncResult<Void>> resultHandler);

    void stop(Handler<AsyncResult<Void>> resultHandler);

}
