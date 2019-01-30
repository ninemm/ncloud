/*
 * Copyright (c) 2015-2018, Eric Huang 黄鑫 (ninemm@126.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package net.ninemm.base.utils;

import java.io.File;

/**
 * Tika 工具类
 *
 * @author Eric.Huang
 * @date 2019-01-15 23:08
 * @package net.ninemm.base.utils
 **/

public class TikaUtils {

    public static String wordToTxt(File file) {
        /*Parser parser = new AutoDetectParser();
        try {
            InputStream inputStream = new FileInputStream(file);
            ContentHandler contentHandler = new BodyContentHandler();
            Metadata metadata = new Metadata();
            ParseContext parseContext = new ParseContext();

            parseContext.set(Parser.class, parser);
            parser.parse(inputStream, contentHandler, metadata, parseContext);
            for (String str : metadata.names()) {
                System.out.println(str + ":" + metadata.get(str));
            }
            inputStream.close();
            return contentHandler.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (TikaException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        return null;
    }

}
