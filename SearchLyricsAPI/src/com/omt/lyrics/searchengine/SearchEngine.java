/**
   Copyright 2013 Dhiral Pandya

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */
package com.omt.lyrics.searchengine;

import java.util.List;

import com.omt.lyrics.beans.SearchLyricsBean;
import com.omt.lyrics.exception.SearchLyricsException;

/**
 * Search engine is use to search your lyrics query. you can make your own
 * search engine by implementing this interface
 * 
 * @author omt
 * @author Dhiral Pandya (dhiralpandya@gmail.com)
 * @since 10 Sep 2013
 * @version 1.0
 * 
 */
public interface SearchEngine {

	/**
	 * Search your query
	 * 
	 * @param searchString
	 * @return
	 */
	public List<String> search(String searchString)
			throws SearchLyricsException;

	/**
	 * Get Search string (Means your query ) from bean.
	 * 
	 * @param bean
	 * @return
	 */
	public String getSearchString(SearchLyricsBean bean);
}
