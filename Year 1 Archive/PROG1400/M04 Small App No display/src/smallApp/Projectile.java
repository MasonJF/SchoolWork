package smallApp;

abstract class Projectile extends Thread{
    private int toc;
    private int x;
    private int y;
    private int dx;
    private int dy;
    private int cnt;
    private String name;

    Projectile(int dx, int dy, String name) {
        this.dx = dx;
        this.dy = dy;
        this.name = name;
    }

    public void run() {
        while(true) {
            this.ticToc();
        }
    }

    private void ticToc() {
        int tick = toc;
        toc = tick + 1;
        projPos();
        if (this.y == 0  && cnt == 0) {
            bounce();
        }else if (this.y == 0 && cnt == 1){
            explode();
        }
    }
    private void bounce(){
        dy = 2;
        dx = dx - 2;
        cnt += 1;

    }
    private void projPos(){
        int posX = x;
        x = posX + dx;
        y += dy;
        dy = dy - 1;
        System.out.println(name + " location is currently: " + x + " " + y);

    }

    void setDx(int dx) {
        this.dx = dx;
    }

    void setDy(int dy) {
        this.dy = dy;
    }

    abstract void explode();

} // Projectile Close

