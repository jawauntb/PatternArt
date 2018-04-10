// Fun with matrices.
//                               L. McGeoch, 3/2004

public class Patterns {
    
    public static void main (String[] args) {
        
        new PatFrame();
    }
    
    //////////////////////////////////////////////////////////////////////
    // getChoices():  returns the names that should appear in the pop-up menu
    //////////////////////////////////////////////////////////////////////
    
    public static String[] getChoices() {
        
        String[] choices = {"Blank", "Solid", "Diagonal", "Lines", "Triangle", "Checkerboard", "Diamond" };
        return choices;
    }
    
    //////////////////////////////////////////////////////////////////////
    // makePicture():  calls the appropriate method to make a drawing
    //////////////////////////////////////////////////////////////////////
    
    public static void makePicture(boolean[][] b, String name) {
        if (name.equals("Solid"))
            makeSolid(b);
        else if (name.equals("Diagonal"))
            makeDiagonal(b);
        else if (name.equals("Lines"))
            makeLines(b);
        else if (name.equals("Triangle"))
            makeTriangle(b);
        else if (name.equals("Checkerboard"))
            makeCheckerboard(b);
        else if (name.equals("Diamond"))
            makeDiamond(b);
    }
    
    //////////////////////////////////////////////////////////////////////
    // These methods draw various shapes
    //////////////////////////////////////////////////////////////////////
    
    public static void makeSolid (boolean[][] b) {
        
        int n= b.length;
        for (int i=0; i<n; ++i) {
            for (int j=0; j<n; ++j)
                b[i][j] = true;
        }
    }
    
    public static void makeDiagonal (boolean[][] b) {
        
        int n = b.length;
        for (int i=0; i<n; ++i) {
            b[i][i] = true;
        }
    }
    
    public static void makeLines (boolean[][] b) {
        
        int n = b.length;
        for (int i=0; i<n; i+=2) {
            for (int j=0; j<n; ++j)
                b[i][j] = true;
        }
    }
    public static void makeTriangle (boolean[][] b) {
        
        int n = b.length;
        for(int i=0; i<n; i++){
            for (int j=i; j>=0; --j)
                b[i][j] = true;
        }
    }
    public static void makeCheckerboard (boolean [][] b) {
        
        int n = b.length;
        for(int i=0; i<n; i++){
            if(i % 2 ==0 || i == 0){
                b[i][i] = true;
            }
        }
    }
    public static void makeDiamond (boolean [][] b) {
        int mid=(b.length/2);
        int row=0;
        int start=mid;
        int span=0;
        while (row < mid){
            span=row*2;
            b[row][start-row]=true;//value at center column-row is true
            for(int sp=0;sp<span-1;sp++){
                b[row][((start-row)+sp)]=true;
            }
            row++;
        }
        while (row<(b.length-1)){
            span=row*2;
            b[row][start-row]=true;
            for(int min=0;min<span-1;min--){
                b[row][((start+row)-min)]=true;
            }
            row++
        }
    }
    
    
    
}

}


