package org.elasticsearch.plugin.example;


import com.google.common.math.IntMath;
import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.rest.BytesRestResponse;
import org.elasticsearch.rest.RestChannel;
import org.elasticsearch.rest.RestController;
import org.elasticsearch.rest.RestHandler;
import org.elasticsearch.rest.RestRequest;
import org.elasticsearch.rest.RestStatus;

public class HelloRestHandler implements RestHandler {
    @Inject public HelloRestHandler(RestController restController) {
        restController.registerHandler(RestRequest.Method.GET, "/_hello", this);
    }

    @Override public void handleRequest(RestRequest request, RestChannel channel) {
        String who = request.param("who");
        String whoSafe = (who != null) ? who : "world";
        //BytesRestResponse instead of StringRestResponse in new version of ES
        //https://github.com/elastic/elasticsearch/issues/9012
        //channel.sendResponse(new StringRestResponse(RestStatus.OK, "Hello, " + whoSafe + "!"));
        String string =
            (who != null && who.equals("testJar") && IntMath.checkedMultiply(1, 1) == 1) ?
                " test Jar succeeded ~~" :
                "";
        channel
            .sendResponse(new BytesRestResponse(RestStatus.OK, "Hello, " + whoSafe + "!" + string));
    }
}
