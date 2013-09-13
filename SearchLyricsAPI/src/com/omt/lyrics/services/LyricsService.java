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
package com.omt.lyrics.services;

import java.util.List;

import com.omt.lyrics.beans.Lyrics;
import com.omt.lyrics.beans.LyricsServiceBean;
import com.omt.lyrics.exception.SearchLyricsException;

/**
 * This interface is require to implement your own service
 * 
 * @author omt
 * @author Dhiral Pandya (dhiralpandya@gmail.com)
 * @since 11 Sep 2013
 * @version 1.0
 * 
 */
public interface LyricsService {

	/**
	 * Return list of all found lyrics.
	 * 
	 * @param bean
	 * @return
	 */
	public List<Lyrics> getLyrics(LyricsServiceBean bean)
			throws SearchLyricsException;

}
