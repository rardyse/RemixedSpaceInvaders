package serie5.Project.Model;

    public class Point {
        private double x;
        private double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getX() { return x; }
        public double getY() { return y; }

        public void translate(Vector v) {
            this.x += v.getDx();
            this.y += v.getDy();
        }
    }
