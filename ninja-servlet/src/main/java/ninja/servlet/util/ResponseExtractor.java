/**
 * Copyright (C) 2012-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ninja.servlet.util;

import javax.servlet.http.HttpServletResponse;

import ninja.Context;
import ninja.params.ArgumentExtractor;
import ninja.servlet.ContextImpl;

public class ResponseExtractor implements ArgumentExtractor<HttpServletResponse> {

    @Override
    public HttpServletResponse extract(Context context) {

        if (context instanceof ContextImpl) {
            return ((ContextImpl) context).getHttpServletResponse();
        } else {
            throw new RuntimeException(
                    "RequestExtractor only works with Servlet container implementation of Context.");
        }

    }

    @Override
    public Class<HttpServletResponse> getExtractedType() {
        return HttpServletResponse.class;
    }

    @Override
    public String getFieldName() {
        return null;
    }
}