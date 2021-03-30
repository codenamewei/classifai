/*
 * Copyright (c) 2021 CertifAI Sdn. Bhd.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Apache License, Version 2.0 which is available at
 * https://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 */
package ai.classifai.router;

import ai.classifai.database.wasabis3.WasabiQuery;
import ai.classifai.util.ParamConfig;
import ai.classifai.util.http.HTTPResponseHandler;
import ai.classifai.util.message.ReplyHandler;
import ai.classifai.util.type.AnnotationHandler;
import ai.classifai.util.type.AnnotationType;
import io.vertx.core.Vertx;
import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.RoutingContext;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class CloudEndpoint
{
    @Setter private Vertx vertx = null;

    /**
     * PUT http://localhost:{port}/v2/:annotation_type/wasabi/newproject/:project_name
     *
     * response body
     * {
     *      cloud_id id / email: codenamewei/codenamewei@yahoo.com
     *      access_key         : DFRTDROTOX8Q30ZSHV15
     *      secret_access_key  : 2C7EYgzkfDWdtNCe12B5E7iQeQuCCEYEg9v62zqB
     *      bucket_list        : ["bucket 1, bucket 2"]
     * }
     *
     * @param context
     */
    public void createWasabiCloudProject(RoutingContext context)
    {
        AnnotationType type = AnnotationHandler.getTypeFromEndpoint(context.request().getParam(ParamConfig.getAnnotationTypeParam()));

        String projectName = context.request().getParam(ParamConfig.getProjectNameParam());

        context.request().bodyHandler(requestBody ->
        {
            try
            {
                JsonObject requestJsonObject = requestBody.toJsonObject();

                requestJsonObject
                        .put(ParamConfig.getProjectNameParam(), projectName)
                        .put(ParamConfig.getAnnotationTypeParam(), type.ordinal());

                DeliveryOptions createS3Ops = new DeliveryOptions().addHeader(ParamConfig.getActionKeyword(), WasabiQuery.getWriteCredential());

                vertx.eventBus().request(WasabiQuery.getQueue(), requestJsonObject, createS3Ops, fetch ->
                {
                    JsonObject response = (JsonObject) fetch.result().body();

                    if (ReplyHandler.isReplyOk(response))
                    {
                        HTTPResponseHandler.configureOK(context);
                    }
                    else
                    {
                        HTTPResponseHandler.configureOK(context, ReplyHandler.reportUserDefinedError("Failed to load project " + projectName));
                    }
                });

            }
            catch (Exception e)
            {
                HTTPResponseHandler.configureOK(context, ReplyHandler.reportUserDefinedError(e.getMessage()));

            }
        });


    }
}