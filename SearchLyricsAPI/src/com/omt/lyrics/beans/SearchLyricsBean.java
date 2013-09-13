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
package com.omt.lyrics.beans;

import com.omt.lyrics.searchengine.SearchEngine;
import com.omt.lyrics.util.Engines;
import com.omt.lyrics.util.Sites;

/**
 * This bean is use to search lyrics using LyricsParsers. <br/>
 * <b>Example</b> <br/>
 * SearchLyrics searchLyrics = new SearchLyrics();<br/>
 * <br/>
 * SearchLyricsBean bean = new SearchLyricsBean();<br/>
 * bean.setSongName("lucky one");<br/>
 * bean.setSongArtist("Taylor swift");<br/>
 * bean.setSites(Sites.METROLYRICS);<br/>
 * List<Lyrics> lyrics = searchLyrics.searchLyrics(bean);<br/>
 * 
 * @author omt
 * @author Dhiral Pandya (dhiralpandya@gmail.com)
 * @since 10 Sep 2013
 * @version 1.0
 * 
 */
public class SearchLyricsBean {

	private String searchStartWith = "";
	private String songName = "";
	private String songArtist = "";
	private String songAlbum = "";
	private String searchEndWith = "";
	private Sites sites = Sites.SONGMEANINGS;
	private int topMaxResult = 1;
	private Engines engines = Engines.GOOGLE;

	/**
	 * Get Search start with
	 * 
	 * @return
	 */
	public String getSearchStartWith() {
		return searchStartWith;
	}

	/**
	 * Set search start with<br/>
	 * This param will use as a first string when api search lyrics for songs. <br>
	 * By default is it blank string.
	 * 
	 * @param searchStartWith
	 */
	public void setSearchStartWith(String searchStartWith) {
		this.searchStartWith = searchStartWith;
	}

	/**
	 * Get song name
	 * 
	 * @return
	 */
	public String getSongName() {
		return songName;
	}

	/**
	 * Set song name
	 * 
	 * @param songName
	 */
	public void setSongName(String songName) {
		this.songName = songName;
	}

	/**
	 * Get song artist
	 * 
	 * @return
	 */
	public String getSongArtist() {
		return songArtist;
	}

	/**
	 * Set song artist.
	 * 
	 * @param songArtist
	 */
	public void setSongArtist(String songArtist) {
		this.songArtist = songArtist;
	}

	/**
	 * Get album name
	 * 
	 * @return
	 */
	public String getSongAlbum() {
		return songAlbum;
	}

	/**
	 * Set album name
	 * 
	 * @param songAlbum
	 */
	public void setSongAlbum(String songAlbum) {
		this.songAlbum = songAlbum;
	}

	/**
	 * Get search end with
	 * 
	 * @return
	 */
	public String getSearchEndWith() {
		return searchEndWith;
	}

	/**
	 * Set search end with<br/>
	 * This param will use as a last string when api search lyrics for songs. <br>
	 * By default is it blank string.
	 * 
	 * @param searchEndWith
	 */
	public void setSearchEndWith(String searchEndWith) {
		this.searchEndWith = searchEndWith;
	}

	/**
	 * It will return search site Enum. This site will use for searching lyrics.<br>
	 * See {@link Sites} <br>
	 * By Default it is Sites.SONGMEANINGS
	 * 
	 * @return {@link Sites}
	 */
	public Sites getSites() {
		return sites;
	}

	/**
	 * Set search site Enum. This site will use for searching lyrics.<br>
	 * See {@link Sites} <br>
	 * By Default it is Sites.SONGMEANINGS
	 * 
	 * @return {@link Sites}
	 */
	public void setSites(Sites sites) {
		this.sites = sites;
	}

	/**
	 * Return int contains MAX number of lyrics you want in search. For Best
	 * result set it to 1 (one)
	 * 
	 * @return
	 */
	public int getTopMaxResult() {
		return topMaxResult;
	}

	/**
	 * Set max number of lyrics you want in search. For Best result set it to 1
	 * (one), By default it is 1.
	 * 
	 * @param topMaxResult
	 */
	public void setTopMaxResult(int topMaxResult) {
		this.topMaxResult = topMaxResult;
	}

	/**
	 * Return search engines that is used to search lyrics. <br>
	 * See ({@link Engines})
	 * 
	 * @return ({@link SearchEngine})
	 */
	public Engines getEngines() {
		return engines;
	}

	/**
	 * Set search engines. Which search engine you want to use for searching
	 * your lyrics. <br>
	 * By Default it is google. <br>
	 * See ({@link Engines})
	 * 
	 * @param engines
	 */
	public void setEngines(Engines engines) {
		this.engines = engines;
	}

}
