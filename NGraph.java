/**
 * Created by Joseph on 2/2/2017.
 */
//Grab string call it s and grab size and call it size
public class NGraph {
    if(size<1){
        size=1;
    }//end if

    s =s.replaceAll(" ","");
    s=s.toUpperCase();

    if(size<=s.length()){
        ArrayList<String> array = new ArrayList<String>();
        for(int i=0; i<s.length()-size+1;i++){
            String letters = s.substring(i,i+size);
            array.add(i,letters);
        }//end for loop

        ArrayList<String> listed = new ArrayList<String>();

        for(int j=0;j<array.size();j++){
            String l=array.get(j);
            if(listed.contains(l)==false){
                listed.add(l);
                if(array.lastIndexOf(l)==j){
                    output.setText(l + " = 1 at positions " + j);
                }//end if

                else{
                    ArrayList<Integer> position = new ArrayList<Integer>();
                    int count =0;
                    for(int k=0;k<array.size();k++){
                        if(array.get(k).equals(l)){
                            count++;
                            position.add(k);
                        }//end if
                    }//end for
                    output.setText(l + " = " + count + " at positions " + position);
                }//end else
            }//end if

        }//end for loop
    }//end if
}
