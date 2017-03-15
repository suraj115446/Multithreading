package mt;

/**
 * Created by srawa5 on 3/15/2017.
 */
public enum Colors {

    RED(255,0,0),
    ORANGE(100,200,100),
    YELLOW(155,200,300),
    GREEN(0,255,0),
    BLUE(0,0,255),
    INDIGO(155,200,300),
    VIOLET(155,200,300);

    private final int r;
    private final int g;
    private final int b;

    Colors(int r, int g, int b) {
        System.out.println("hello!! guys i am singleton");

        this.r = r;
        this.g = g;
        this.b = b;
    }

    public int getG() {
        return g;
    }

    public int getB() {
        return b;
    }

    public int getR() {

        return r;
    }

    public int[] mixColors(Colors c1, Colors... c2){
        int[] arr= new int[3];
        arr[0] = this.getR()+c1.getR();
        arr[1] = this.getG()+c1.getG();
        arr[2] = this.getB()+c1.getB();

        arr[0] /=2;
        arr[1] /=2;
        arr[2] /=2;
        for (Colors colors: c2){
            arr[0] += colors.getR();
            arr[1] += colors.getG();
            arr[2] += colors.getB();
        }

        arr[0] /=c2.length;
        arr[1] /=c2.length;
        arr[2] /=c2.length;

        return arr;
    }
}
