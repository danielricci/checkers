/**
* Daniel Ricci <thedanny09@gmail.com>
*
* Permission is hereby granted, free of charge, to any person
* obtaining a copy of this software and associated documentation
* files (the "Software"), to deal in the Software without restriction,
* including without limitation the rights to use, copy, modify, merge,
* publish, distribute, sublicense, and/or sell copies of the Software,
* and to permit persons to whom the Software is furnished to do so, subject
* to the following conditions:
*
* The above copyright notice and this permission notice shall be included in
* all copies or substantial portions of the Software.
*
*
* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
* IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
* FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
* THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
* LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
* FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS
* IN THE SOFTWARE.
*/

package engine.views.factory;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import engine.controllers.BoardGameController;

@SuppressWarnings("serial")
public final class BoardGameView extends BaseView {
	
	private final JPanel _gamePanel = new JPanel(new GridBagLayout());	
	
	public BoardGameView() {
		super(new BoardGameController());
	}
	
	public class BoardPosition extends JPanel {

		private JLabel _coordinateLabel = null;
		private int _coordinate = -1;
		
		private Color _color = null;
	    private Image _image = null;
	    private boolean _locked = false;
	    
	    private BoardPosition _left = null;
	    private BoardPosition _top = null;
	    private BoardPosition _right = null;
	    private BoardPosition _bottom = null;	    
	    
	    public BoardPosition(Color color, Image image) {
	    	_color = color;
	    	_image = image;
	    	setBackground(_color);
	    	addListeners();
	    } 
	   
	    private void addListeners() {
	    	addMouseListener(new MouseAdapter() {  		
	    		@Override public void mouseEntered(MouseEvent e) {
	    			return;
	    			/*
	    			if(_controller.isGameOver())
	    			{
	    				return;
	    			}
	    			
	    			Object source = e.getSource();
	    			if(source instanceof BoardPosition) {
	    				BoardPosition position = (BoardPosition)source;
	    				
	    				if(!_locked) {
	    					position.setBackground(Color.LIGHT_GRAY);
	    					try {
								_image = new ImageIcon(position.getClass().getResource(_controller.getPlayerToken())).getImage();
							} catch (Exception e1) {
								e1.printStackTrace();
							}
	    				}
    				
						position.repaint();
	    			}
	    			*/
	    		}
	    		@Override public void mouseExited(MouseEvent e) {
	    			return;
	    			/*
	    			if(_controller.isGameOver())
	    			{
	    				return;
	    			}
    			
    				if(!_locked)
    				{
    					_image = null;	
    				}
    				
    				BoardPosition position = (BoardPosition)e.getSource();
    				setBackground(position._color);
    				*/
	    		}
	    		@Override public void mouseClicked(MouseEvent e) {
					return;
					/*
	    			if(_controller.isGameOver())
	    			{
	    				return;
	    			}
	    			
					// Get the board that we selected to give our event handler some context
					BoardPosition position = (BoardPosition)e.getSource();
				
					// If the player can play and there is no selection yet
					// then take ownership of the position and put our token
					if(!_locked) {
						try {
							_image = new ImageIcon(position.getClass().getResource(_controller.getPlayerToken())).getImage();
							_controller.performMove(e);
							position._locked = true;
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
					position.repaint();
					*/
				}
			});
	    }
	    
	    private void setCoordinate(int coordinate) {
	    	_coordinateLabel = new JLabel(coordinate + "");
	    	_coordinateLabel.setForeground(Color.WHITE);
	    	add(_coordinateLabel);
	    }
	    

	    public void addLeft(BoardPosition position) { _left = position; }
	    public void addTop(BoardPosition position) { _top = position; }
	    public void addRight(BoardPosition position) { _right = position; }
	    public void addBottom(BoardPosition position) { _bottom = position; }
	    	    
	    public BoardPosition getNeighbourTop() { return _top; }
	    public BoardPosition getNeighbourBottom() { return _bottom; }
	    public BoardPosition getNeighbourLeft() { return _left; }
	    public BoardPosition getNeighbourRight() { return _right; }

		public boolean equals(BoardPosition bp) 
		{
			if(bp == null || bp == this)
			{
				return false;
			}
			
			return bp._image == _image;
		}
	}
	
	@Override public void render() {
		_gamePanel.setBackground(Color.RED);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		// get the grid selection of our user control
		int gridSize = 12;
		
		Color[] colors = {
			Color.WHITE,
			Color.BLACK
		};
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		
		ArrayList<ArrayList<BoardPosition>> positions = new ArrayList<ArrayList<BoardPosition>>();
		
		// Create a list of panels based on the n-by-n grid selection
		for (int row = 0, coordinate = 1; row < gridSize; ++row) {
			
			ArrayList<BoardPosition> rowPositions = new ArrayList<BoardPosition>();
			for (int col = 0, colorOffset = (row % 2 == 0 ? 0 : 1);  col < gridSize; ++col) {
			
				// If you are playing chess, these can be removed
				Color tileColor = colors[(col + colorOffset) % colors.length];
				if(tileColor == Color.WHITE) {
					continue;
				}
				
				gbc.gridx = col;
				gbc.gridy = row;
					
				/*
				Border border = null;
				if (row < (gridSize - 1)) {
					if (col < (gridSize - 1)) {
						border = new MatteBorder(1, 1, 0, 0, Color.WHITE);
					} else {
						border = new MatteBorder(1, 1, 0, 1, Color.WHITE);
					}
				} else {
					if (col < (gridSize - 1)) {
						border = new MatteBorder(1, 1, 1, 0, Color.WHITE);
					} else {
						border = new MatteBorder(1, 1, 1, 1, Color.WHITE);
					}
				}*/
				//position.setBorder(border);

			
					
				BoardPosition position = new BoardPosition(tileColor, null);
				position.setCoordinate(coordinate++);
				
				_gamePanel.add(position, gbc);

				// Links them as a row, this is done so that we can associate their neighbors
				// accordingly
				if(!rowPositions.isEmpty()) {
					rowPositions.get(rowPositions.size() - 1).addRight(position);
					position.addLeft(rowPositions.get(rowPositions.size() - 1));
				}
				
				rowPositions.add(position);
			}
			
			// if we have rows in our list
			if(!positions.isEmpty()) {
				
				// Get the last row that has been rendered and link them together by 
				// reference each others top and bottom.  Once this block gets executed
				// they will be able to reference each other as neighbors
				ArrayList<BoardPosition> previous = positions.get(positions.size() - 1);
				for(int i = 0; i < previous.size(); ++i) {
					previous.get(i).addBottom(rowPositions.get(i));
					rowPositions.get(i).addTop(previous.get(i));
				}
			}
			positions.add(rowPositions);
		}
		
		// Add our panels
		add(_gamePanel);
	}
}