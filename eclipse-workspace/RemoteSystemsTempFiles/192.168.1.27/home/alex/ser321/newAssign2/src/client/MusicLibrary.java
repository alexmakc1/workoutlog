 package ser321.assign2.mack;
 
 
public class MusicLibrary extends MediaLibraryGui implements
TreeWillExpandListener,
ActionListener,
TreeSelectionListener {


public static void main(String args[]) {
	System.out.println("HERE");
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