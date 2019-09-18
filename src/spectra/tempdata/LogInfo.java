/*
 * Copyright 2016 John Grosh (jagrosh).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package spectra.tempdata;

import java.util.HashMap;

/**
 *
 * @author John Grosh (jagrosh)
 */
public class LogInfo {
    private final HashMap<String,String[]> info;
    
    public LogInfo()
    {
        info = new HashMap<>();
    }
    
    public synchronized void addInfo(String id, Type type, String modName, String modDiscrim, String reason)
    {
        info.put(id+"|"+type.toString(),new String[]{"**"+modName+"**#"+modDiscrim, reason});
    }
    
    public synchronized String[] removeInfo(String id, Type type)
    {
        return info.remove(id+"|"+type.toString());
    }
    
    public enum Type {
        BAN, UNBAN, SOFTBAN, SOFTUNBAN
    }
}
