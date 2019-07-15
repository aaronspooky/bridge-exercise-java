interface Renderer {
    String whatToRenderAs();
}

abstract class Shape
{
    protected Renderer renderer;

    public Shape(Renderer renderer) {
        this.renderer = renderer;
    }

    public abstract String getName();
}

class Triangle extends Shape
{
    public Triangle(Renderer renderer) {
        super(renderer);
    }

    @Override
    public String getName()
    {
        return "Triangle";
    }

    @Override
    public String toString() {
        return String.format("Drawing %s as %s", getName(), renderer.whatToRenderAs());
    }
}

class Square extends Shape
{
    public Square(Renderer renderer) {
        super(renderer);
    }

    @Override
    public String getName()
    {
        return "Square";
    }

    @Override
    public String toString() {
        return String.format("Drawing %s as %s", getName(), renderer.whatToRenderAs());
    }
}

// imagine VectorTriangle and RasterTriangle are here too

class VectorRenderer implements Renderer {

    @Override
    public String whatToRenderAs() {
        return String.format("lines");
    }
}

class RasterRenderer implements Renderer {

    @Override
    public String whatToRenderAs() {
        return String.format("pixels");
    }
}

public class Demo {

    public static void main(String[] args) {
        System.out.println(new Triangle(new RasterRenderer()).toString());
    }
}
