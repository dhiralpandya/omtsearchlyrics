Search Lyrics API
===============

Java SearchLyricsAPI,  It is pure java based search api to seach songs lyrics.


Example 1 :Search By Site
===============

        SearchLyrics searchLyrics = new SearchLyrics();
		SearchLyricsBean bean = new SearchLyricsBean();
		bean.setSongName("lucky one");
		bean.setTopMaxResult(1);
		bean.setSongArtist("Taylor swift");
		bean.setSites(Sites.SONGMEANINGS);

		List<Lyrics> lyrics;
		try {
			lyrics = searchLyrics.searchLyrics(bean);
			for (Lyrics lyric : lyrics) {
				System.out.println("Link :" + lyric.getLink());
				System.out.println("Site :" + lyric.getSites().getName());
				System.out.println("Text :" + lyric.getText());
			}
		} catch (SearchLyricsException e) {
			e.printStackTrace();
		}





Example 2 : Search by Service
===============


        SearchLyrics searchLyrics = new SearchLyrics();
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
		  e.printStackTrace();
		 }
