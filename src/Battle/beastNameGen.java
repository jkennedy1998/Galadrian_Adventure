package Battle;

/**
 * Created by Jared on 12/22/2016.
 */
public class beastNameGen {
    public static String[] vowels = {"a","e","i","o","u"},
            constanants = {"b","c","d","f","g","h","j","k","ck","l","m","n","p","qu","r","s","sh","t","th","v","w","x","y","z"},
            roots = {"an","a","abs","arist","adip","arct","aer","agri","amor","patri","danth","matri","acri",
                    "phobe","nec","necre","lux","lum","luna","acra","phon","ahpobe","belle","bel","perp","stir","bane","wend"};



    public static void assighnName(String beast){
        adventurerework.tempBeastName = getRootedName();

    }
    public static String getRootedName(){

        String rooted = "";
        for(int scan = 0; scan < 2; scan++){
            rooted+=randomRoot();
        }
        return rooted;
    }

    public static void getRandomName (){
        System.out.print(randomConsanant()+randomVowel()+randomConsanant()+randomVowel()+randomConsanant()+randomVowel()+randomConsanant());
    }
    public static String randomVowel(){
        if(Math.random()<.2)return "";
        int temp = (int)Math.floor(Math.random()*vowels.length);
        return vowels[temp];
    }
    public static String randomConsanant(){
        if(Math.random()<.3)return "";
        int temp = (int)Math.floor(Math.random()*constanants.length);
        return constanants[temp];
    }
    public static String randomRoot(){

        int temp = (int)Math.floor(Math.random()*roots.length);
        return roots[temp];
    }


}


