package interview.designmode;

public class StaticProxy{
    public static void main(String[] args) {
        ImageSubject imageSubject=new proxyImage("/resource/img1.jpg");
        imageSubject.display();
    }
}

interface ImageSubject{
    void display();
}
class RealImageSubject implements ImageSubject{
    private String filename;
    public RealImageSubject(String filename){
        this.filename=filename;
    }
    @Override
    public void display(){
        System.out.println("Display"+filename);
    }
    private void loadFromDisk(String filename){
        System.out.println("Loading " + filename);
    }
}
class proxyImage implements ImageSubject{
    private RealImageSubject realImageSubject;
    private String filename;
    public proxyImage(String filename){
        this.filename = filename;
    }
    @Override
    public void display(){
        if(realImageSubject==null){
            realImageSubject=new RealImageSubject(filename);
        }
        realImageSubject.display();
    }
}
