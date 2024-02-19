package Lesson9.Assignment1.Question5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DrawingProgram extends JFrame {

    private enum ShapeType {

        LINE, RECTANGLE, CIRCLE
    }

    private ShapeType currentShape = ShapeType.LINE;
    private Point startPoint;
    private Point endPoint;

    private DrawingCanvas canvas;

    public DrawingProgram() {

        setTitle("Simple Drawing Program");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        canvas = new DrawingCanvas();
        canvas.addMouseListener(new DrawingMouseListener());
        canvas.addMouseMotionListener(new DrawingMouseListener());

        JPanel controlsPanel = new JPanel();
        JButton lineButton = new JButton("Line");
        JButton rectangleButton = new JButton("Rectangle");
        JButton circleButton = new JButton("Circle");

        lineButton.addActionListener(e -> setCurrentShape(ShapeType.LINE));
        rectangleButton.addActionListener(e -> setCurrentShape(ShapeType.RECTANGLE));
        circleButton.addActionListener(e -> setCurrentShape(ShapeType.CIRCLE));

        controlsPanel.add(lineButton);
        controlsPanel.add(rectangleButton);
        controlsPanel.add(circleButton);

        setLayout(new BorderLayout());
        add(canvas, BorderLayout.CENTER);
        add(controlsPanel, BorderLayout.SOUTH);
    }

    private void setCurrentShape(ShapeType shapeType) {

        currentShape = shapeType;
    }

    private class DrawingMouseListener extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent e) {

            startPoint = e.getPoint();
        }

        @Override
        public void mouseReleased(MouseEvent e) {

            endPoint = e.getPoint();

            switch (currentShape) {

                case LINE:
                    canvas.addShape(new Line(startPoint, endPoint));
                    break;
                case RECTANGLE:
                    canvas.addShape(new Rectangle(startPoint, endPoint));
                    break;
                case CIRCLE:
                    canvas.addShape(new Circle(startPoint, endPoint));
                    break;
            }

            startPoint = null;
            endPoint = null;
        }

        @Override
        public void mouseDragged(MouseEvent e) {

            endPoint = e.getPoint();
            canvas.repaint();
        }
    }

    private class DrawingCanvas extends JPanel {

        private java.util.List<Shape> shapes = new java.util.ArrayList<>();

        public void addShape(Shape shape) {

            shapes.add(shape);
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {

            super.paintComponent(g);

            for (Shape shape : shapes) {

                shape.draw(g);
            }

            if (startPoint != null && endPoint != null) {

                drawCurrentShape(g);
            }
        }

        private void drawCurrentShape(Graphics g) {

            g.setColor(Color.BLACK);

            switch (currentShape) {

                case LINE:
                    g.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
                    break;
                case RECTANGLE:
                    int width = endPoint.x - startPoint.x;
                    int height = endPoint.y - startPoint.y;
                    g.drawRect(startPoint.x, startPoint.y, width, height);
                    break;
                case CIRCLE:
                    int diameter = Math.max(Math.abs(endPoint.x - startPoint.x), Math.abs(endPoint.y - startPoint.y));
                    g.drawOval(startPoint.x, startPoint.y, diameter, diameter);
                    break;
            }
        }
    }

    private interface Shape {

        void draw(Graphics g);
    }

    private class Line implements Shape {

        private final Point start;
        private final Point end;

        public Line(Point start, Point end) {

            this.start = start;
            this.end = end;
        }

        @Override
        public void draw(Graphics g) {

            g.setColor(Color.BLACK);
            g.drawLine(start.x, start.y, end.x, end.y);
        }
    }

    private class Rectangle implements Shape {

        private final Point topLeft;
        private final Point bottomRight;

        public Rectangle(Point topLeft, Point bottomRight) {

            this.topLeft = topLeft;
            this.bottomRight = bottomRight;
        }

        @Override
        public void draw(Graphics g) {

            g.setColor(Color.BLACK);
            int width = bottomRight.x - topLeft.x;
            int height = bottomRight.y - topLeft.y;
            g.drawRect(topLeft.x, topLeft.y, width, height);
        }
    }

    private class Circle implements Shape {

        private final Point center;
        private final int diameter;

        public Circle(Point start, Point end) {
            this.center = new Point((start.x + end.x) / 2, (start.y + end.y) / 2);
            this.diameter = Math.max(Math.abs(end.x - start.x), Math.abs(end.y - start.y));
        }

        @Override
        public void draw(Graphics g) {

            g.setColor(Color.BLACK);
            g.drawOval(center.x - diameter / 2, center.y - diameter / 2, diameter, diameter);
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            DrawingProgram drawingProgram = new DrawingProgram();
            drawingProgram.setVisible(true);

        });
    }
}
