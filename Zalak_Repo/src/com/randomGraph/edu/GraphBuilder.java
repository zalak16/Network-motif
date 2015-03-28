package com.randomGraph.edu;

import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.DefaultModalGraphMouse;
import edu.uci.ics.jung.visualization.control.ModalGraphMouse;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import edu.uci.ics.jung.visualization.renderers.Renderer;
import org.apache.commons.collections15.Transformer;
import javax.swing.*;
import java.awt.*;
/**
 * Created by joglekaa on 4/14/14.
 */
public class GraphBuilder {
	
	int graphSize = 0;
 
		Graph<Integer, String> build() {
        Graph<Integer, String> g = new SparseMultigraph<Integer, String>();
        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);
        g.addVertex(4);
        g.addVertex(5);
        g.addVertex(6);
        g.addVertex(7);
        g.addVertex(8);
        g.addVertex(9);
        g.addEdge("A", 1, 3);
        g.addEdge("B", 1, 2);
        g.addEdge("C", 2, 3);
        g.addEdge("D", 1, 4);
        g.addEdge("E", 1, 5);
        g.addEdge("F", 2, 6);
        g.addEdge("G", 2, 7);
        g.addEdge("H", 3, 8);
        g.addEdge("I", 3, 9);

        return g;
    }

    void display(Graph<Integer, String> g) {
        Layout<Integer, String> layout = new CircleLayout(g);
        layout.setSize(new Dimension(300, 300)); // sets the initial size of the space

        VisualizationViewer<Integer,String> vv =
                new VisualizationViewer<Integer, String>(layout);
        vv.setPreferredSize(new Dimension(350, 350)); //Sets the viewing area size
        vv.getRenderContext().setVertexFillPaintTransformer(new Transformer<Integer, Paint>() {
            @Override
            public Paint transform(Integer integer) {
                if (integer != null && integer.intValue() % 2 == 0) {
                    return Color.GREEN;
                } else {
                    return Color.MAGENTA;
                }
            }
        });
        vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller<Integer>());
        vv.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller<String>());

        vv.getRenderer().getVertexLabelRenderer().setPosition(Renderer.VertexLabel.Position.CNTR);

        DefaultModalGraphMouse m = new DefaultModalGraphMouse();
        m.setMode(ModalGraphMouse.Mode.TRANSFORMING);
        vv.setGraphMouse(m);
        vv.addKeyListener(m.getModeKeyListener());

        JFrame frame = new JFrame("Simple Graph View");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(vv);
        frame.pack();
        frame.setVisible(true);
        System.out.println(g);
    }

    public static void main(String[] args) {
        GraphBuilder builder = new GraphBuilder();
        builder.display(builder.build());
    }

}
