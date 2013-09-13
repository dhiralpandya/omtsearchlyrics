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
package test;

import java.util.List;

import com.omt.lyrics.SearchLyrics;
import com.omt.lyrics.beans.Lyrics;
import com.omt.lyrics.beans.LyricsServiceBean;
import com.omt.lyrics.beans.SearchLyricsBean;
import com.omt.lyrics.exception.SearchLyricsException;
import com.omt.lyrics.util.Sites;

/**
 * This is simple test class for testing SearchLyricsAPI
 * 
 * @author omt
 * @author Dhiral Pandya (dhiralpandya@gmail.com)
 * @since 10 Sep 2013
 * @version 1.0
 * 
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SearchLyrics searchLyrics = new SearchLyrics();
//		SearchLyricsBean bean = new SearchLyricsBean();
//		bean.setSongName("lucky one");
//		// bean.setSongAlbum("passenger");
//		bean.setTopMaxResult(1);
//		bean.setSongArtist("Taylor swift");
//		bean.setSites(Sites.SONGMEANINGS);
//
//		List<Lyrics> lyrics;
//		try {
//			lyrics = searchLyrics.searchLyrics(bean);
//			for (Lyrics lyric : lyrics) {
//				System.out.println("Link :" + lyric.getLink());
//				System.out.println("Site :" + lyric.getSites().getName());
//				System.out.println("Text :" + lyric.getText());
//			}
//		} catch (SearchLyricsException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 

		// Search By Service

		 LyricsServiceBean bean = new LyricsServiceBean();
		 bean.setSongName("let her go");
		 bean.setSongAlbum("passenger");
		
		 List<Lyrics> lyrics;
		 try {
		 lyrics = searchLyrics.searchLyrics(bean);
		 for (Lyrics lyric : lyrics) {
		 System.out.println("Text :" + lyric.getText());
		 }
		
		 } catch (SearchLyricsException e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 }

		// test2();

	}
}
