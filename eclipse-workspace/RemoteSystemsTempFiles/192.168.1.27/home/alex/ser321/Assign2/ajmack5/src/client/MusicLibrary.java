package ser321.assign2.lindquis;

import java.io.*;
import java.util.*;
import java.net.URL;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONTokener;




public class MusicLibrary{
	   private Hashtable<String,MediaDescription> aLib;
	   private static final String fileName="music.json";
	
	public MusicLibrary(){
	      this.aLib = new Hashtable<String,MediaDescription>();
	      try{
	          InputStream is = this.getClass().getClassLoader().getResourceAsStream(this.fileName);
	          if(is==null){
	             is = new FileInputStream(new File(this.fileName));
	          }
	          JSONObject media = new JSONObject(new JSONTokener(is));
	          Iterator<String> it = media.keys();
	          while (it.hasNext()){
	             String mediaTitle = it.next();
	             JSONObject aMed = media.optJSONObject(mediaTitle);
	             if (aMed != null){
	                MediaDescription md = new MediaDescription(aMed);
	                aLib.put(mediaTitle, md);
	                
	             }
	          }
	       }catch (Exception ex){
	          System.out.println("Exception reading "+fileName+": "+ex.getMessage());
	       }
	    }
	
	
	
	
	public String[] getAlbumNames(){
		int counter = 0;
		List<String> albums = new ArrayList<>();
		try{
	        InputStream is = this.getClass().getClassLoader().getResourceAsStream(fileName);
	        if(is==null){
	           is = new FileInputStream(new File(this.fileName));
	        }
	        JSONObject media = new JSONObject(new JSONTokener(is));
	        Iterator<String> it = media.keys();
	        while (it.hasNext()){
	           String mediaTitle = it.next();
	           JSONObject aMed = media.optJSONObject(mediaTitle);
	           if (aMed != null && !albums.contains(aMed.getString("album"))){
	        	   counter++;
	             
	              System.out.println("Read Album from Json: " + aMed.getString("album"));
	              albums.add(aMed.getString("album"));
	           }
	        }

		   String[] albumArray = new String[counter] ;
		  for(int i = 0; i < counter; i++) {
			  albumArray[i] = albums.get(i);
			  
		  }
		  
		  return albumArray;
		}catch (Exception ex){
	          System.out.println("Exception reading "+fileName+": "+ex.getMessage());
	       }
		
		return null;
	}
	
	
	 public void buildInitialTree(DefaultMutableTreeNode root, String base){
	      //set up the context and base name
	      try{
	         root.setUserObject(base);
	      }catch (Exception ex){
	         JOptionPane.showMessageDialog(this,"exception initial tree:"+ex);
	         ex.printStackTrace();
	      }
	   }

	   /**
	    *
	    * method to build the JTree of music shown in the left panel of the UI. The
	    * field tree is a JTree as defined and initialized by MediaLibraryGui class.
	    * it is defined to be protected so it can be accessed by extending classes.
	    * This version of the method uses the music library to get the names of
	    * tracks. Your solutions will need to replace this structure with one that
	    * keeps information particular to both Album and Track (two classes Album.java,
	    * and Track.java). Your music library will store and provide access to Album
	    * and Track objects.
	    * This method is provided to demonstrate one way to add nodes to a JTree based
	    * on an underlying storage structure.
	    * See also the methods clearTree, valueChanged, and getSubLabelled defined in this class.
	    **/
	   public void rebuildTree(){
	      tree.removeTreeSelectionListener(this);
	      //tree.removeTreeWillExpandListener(this);
	      DefaultTreeModel model = (DefaultTreeModel)tree.getModel();
	      DefaultMutableTreeNode root = (DefaultMutableTreeNode)model.getRoot();
	      clearTree(root, model);
	      DefaultMutableTreeNode musicNode = new DefaultMutableTreeNode("Music");
	      model.insertNodeInto(musicNode, root, model.getChildCount(root));
	      // put nodes in the tree for all  registered with the library
	      String[] musicList = library.getTitles();
	      for (int i = 0; i < musicList.length; i++){
	         MediaDescription aMD = library.get(musicList[i]);
	         String aMTitle = aMD.title;
	         debug("Adding song with title:"+aMD.title);
	         DefaultMutableTreeNode toAdd = new DefaultMutableTreeNode(aMTitle);
	         DefaultMutableTreeNode subNode = getSubLabelled(musicNode,aMD.album);
	         if(subNode!=null){ // if album subnode already exists
	            debug("album exists: "+aMD.album);
	            //subNode.add(toAdd);
	            model.insertNodeInto(toAdd, subNode,
	                                 model.getChildCount(subNode));
	         }else{ // album node does not exist
	            DefaultMutableTreeNode anAlbumNode =
	               new DefaultMutableTreeNode(aMD.album);
	            debug("no album, so add one with name: "+aMD.album);
	            //root.add(aCatNode);
	            model.insertNodeInto(anAlbumNode, musicNode,
	                                 model.getChildCount(musicNode));
	            DefaultMutableTreeNode aSubCatNode = 
	               new DefaultMutableTreeNode("aSubCat");
	            debug("adding subcat labelled: "+"aSubCat");
	            model.insertNodeInto(toAdd,anAlbumNode,
	                                 model.getChildCount(anAlbumNode));
	         }
	      }
	      // expand all the nodes in the JTree
	      for(int r =0; r < tree.getRowCount(); r++){
	         tree.expandRow(r);
	      }
	      tree.addTreeSelectionListener(this);
	      //tree.addTreeWillExpandListener(this);
	      //setVisible(true);
	   }

	   private void clearTree(DefaultMutableTreeNode root, DefaultTreeModel model){
	      try{
	         DefaultMutableTreeNode next = null;
	         int subs = model.getChildCount(root);
	         for(int k=subs-1; k>=0; k--){
	            next = (DefaultMutableTreeNode)model.getChild(root,k);
	            debug("removing node labelled:"+(String)next.getUserObject());
	            model.removeNodeFromParent(next);
	         }
	      }catch (Exception ex) {
	         System.out.println("Exception while trying to clear tree:");
	         ex.printStackTrace();
	      }
	   }

	   private DefaultMutableTreeNode getSubLabelled(DefaultMutableTreeNode root,
	                                                 String label){
	      DefaultMutableTreeNode ret = null;
	      DefaultMutableTreeNode next = null;
	      boolean found = false;
	      for(Enumeration<TreeNode> e = root.children();
	          e.hasMoreElements();){
	         next = (DefaultMutableTreeNode)e.nextElement();
	         debug("sub with label: "+(String)next.getUserObject());
	         if (((String)next.getUserObject()).equals(label)){
	            debug("found sub with label: "+label);
	            found = true;
	            break;
	         }
	      }
	      if(found)
	         ret = next;
	      else
	         ret = null;
	      return (DefaultMutableTreeNode)ret;
	   }

	   public void treeWillCollapse(TreeExpansionEvent tee) {
	      debug("In treeWillCollapse with path: "+tee.getPath());
	      tree.setSelectionPath(tee.getPath());
	   }

	   public void treeWillExpand(TreeExpansionEvent tee) {
	      debug("In treeWillExpand with path: "+tee.getPath());
	      //DefaultMutableTreeNode dmtn =
	      //    (DefaultMutableTreeNode)tee.getPath().getLastPathComponent();
	      //System.out.println("will expand node: "+dmtn.getUserObject()+
	      //		   " whose path is: "+tee.getPath());
	   }

	   public void valueChanged(TreeSelectionEvent e) {
	      try{
	         tree.removeTreeSelectionListener(this);
	         DefaultMutableTreeNode node = (DefaultMutableTreeNode)
	            tree.getLastSelectedPathComponent();
	         if(node!=null){
	            String nodeLabel = (String)node.getUserObject();
	            debug("In valueChanged. Selected node labelled: "+nodeLabel);
	            // is this a terminal node?
	            if(node.getChildCount()==0 &&
	               (node != (DefaultMutableTreeNode)tree.getModel().getRoot())){
	               MediaDescription md = library.get(nodeLabel);
	               trackJTF.setText(nodeLabel);
	               authorJTF.setText(md.author);
	               albumJTF.setText(md.album);
	               fileNameJTF.setText(md.fileName);
	             }
	         }
	      }catch (Exception ex){
	         ex.printStackTrace();
	      }
	      tree.addTreeSelectionListener(this);
	   }

	   public void actionPerformed(ActionEvent e) {
	      tree.removeTreeSelectionListener(this);
	      if(e.getActionCommand().equals("Exit")) {
	         System.exit(0);
	      }else if(e.getActionCommand().equals("Save")) {
	         boolean savRes = false;
	         System.out.println("Save "+((savRes)?"successful":"not implemented"));
	      }else if(e.getActionCommand().equals("Restore")) {
	         boolean resRes = false;
	         rebuildTree();
	         System.out.println("Restore "+((resRes)?"successful":"not implemented"));
	      }else if(e.getActionCommand().equals("AlbumAdd")) {
		  
	         System.out.println("AlbumAdd not implemented");
	      }else if(e.getActionCommand().equals("TrackAdd")) {
	         int typeInd = genreJCB.getSelectedIndex();
	         MediaDescription aMD = new MediaDescription(trackJTF.getText().trim(),
	                                                     authorJTF.getText().trim(),
	                                                     albumJTF.getText().trim(),
	                                                     fileNameJTF.getText().trim());
	         library.add(aMD);
	         rebuildTree();
	        /*
	         JFileChooser chooser = new JFileChooser();
	         chooser.setCurrentDirectory(
	            new File(System.getProperty("user.dir")));
	         FileNameExtensionFilter filter = new FileNameExtensionFilter(
	                                                          "mp3 files", "mp3");
	         chooser.setFileFilter(filter);
	         int returnVal = chooser.showOpenDialog(this);
	         if(returnVal == JFileChooser.APPROVE_OPTION) {
	            debug("You chose to open the file: " +
	                                          chooser.getSelectedFile().getName());
	         }
	       */
	      }else if(e.getActionCommand().equals("Search")) {
	         String searchReqURL = pre+artistSearchJTF.getText().trim()+"&album="+albumSearchJTF.getText().trim()+
	                               "&api_key="+lastFMKey+"&format=json";
	         System.out.println("calling fetchAsyncURL with url: "+searchReqURL);
	        
	         Album searchAlbum = new Album().parseLastFMJson(fetchURL(searchReqURL));
	         
	         
	      }else if(e.getActionCommand().equals("Tree Refresh")) {
	         rebuildTree();
	      }else if(e.getActionCommand().equals("TrackRemove")) {
	         System.out.println("TrackRemove not implemented");
	      }else if(e.getActionCommand().equals("AlbumRemove")) {
	    	  MusicLibrary lib = new MusicLibrary();
	    	  lib.getAlbumNames();
	         System.out.println("AlbumRemove not implemented");
	      }else if(e.getActionCommand().equals("AlbumPlay") || e.getActionCommand().equals("TrackPlay")){
	         try{
	            DefaultMutableTreeNode node = (DefaultMutableTreeNode)
	                                            tree.getLastSelectedPathComponent();
	            if(node!=null){
	               String nodeLabel = (String)node.getUserObject();
	               MediaDescription md = library.get(nodeLabel);
	               String fileName = md.fileName;
	               String path = "file://"+System.getProperty("user.dir")+
	                             "/MediaFiles/" + fileName;
	               this.playMedia(path, md.title);
	            }
	         }catch(Exception ex){
	            System.out.println("Execption trying to play media:");
	            ex.printStackTrace();
	         }
	      }
	      tree.addTreeSelectionListener(this);
	   }

	   /**
	    *
	    * A method to do asynchronous url request printing the result to System.out
	    * @param aUrl the String indicating the query url for the lastFM api search
	    *
	    **/
	   public void fetchAsyncURL(String aUrl){
	      try{
	         HttpClient client = HttpClient.newHttpClient();
	         HttpRequest request = HttpRequest.newBuilder()
	            .uri(URI.create(aUrl))
	            .timeout(Duration.ofMinutes(1))
	            .build();
	         client.sendAsync(request, BodyHandlers.ofString())
	            .thenApply(HttpResponse::body)
	            .thenAccept(System.out::println)
	            .join();
	      }catch(Exception ex){
	         System.out.println("Exception in fetchAsyncUrl request: "+ex.getMessage());
	      }
	   }

	   /**
	    *
	    * a method to make a web request. Note that this method will block execution
	    * for up to 20 seconds while the request is being satisfied. Better to use a
	    * non-blocking request.
	    * @param aUrl the String indicating the query url for the lastFM api search
	    * @return the String result of the http request.
	    *
	    **/
	   public String fetchURL(String aUrl) {
	      StringBuilder sb = new StringBuilder();
	      URLConnection conn = null;
	      InputStreamReader in = null;
	      try {
	         URL url = new URL(aUrl);
	         conn = url.openConnection();
	         if (conn != null)
	            conn.setReadTimeout(20 * 1000); // timeout in 20 seconds
	         if (conn != null && conn.getInputStream() != null) {
	            in = new InputStreamReader(conn.getInputStream(),
	                                       Charset.defaultCharset());
	            BufferedReader br = new BufferedReader(in);
	            if (br != null) {
	               int ch;
	               // read the next character until end of reader
	               while ((ch = br.read()) != -1) {
	                  sb.append((char)ch);
	               }
	               br.close();
	            }
	         }
	         in.close();
	      } catch (Exception ex) {
	         System.out.println("Exception in url request:"+ ex.getMessage());
	      } 
	     // System.out.println("TEST STRING: \n\n\n\n\n" + sb.toString());
	      return sb.toString();
	   }

	   public boolean sezToStop(){
	      return stopPlaying;
	   }

	   
	   
	   public static void main(String args[]) {
	      String name = "first.last";
	      String key = "use-your-last.fm-key-here";
	      if (args.length >= 2){
	         //System.out.println("java -cp classes:lib/json.lib ser321.assign2.lindquist."+
	         //                   "MediaLibraryApp \"Lindquist Music Library\" lastFM-Key");
	         name = args[0];
	         key = args[1];
	      }
	      try{
	         //System.out.println("calling constructor name "+name);
	         MediaLibraryApp mla = new MediaLibraryApp(name,key);
	      }catch (Exception ex){
	         ex.printStackTrace();
	      }
	   }
	}
	
	
}