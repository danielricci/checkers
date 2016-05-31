/**
* Daniel Ricci <2016> <thedanny09@gmail.com>
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

package mainline.models;

import java.util.Observer;

public final class GamePieceModel extends GameModel {

    private int _coordinate;
	private boolean _isLocked; 
	
	private PlayerModel _player;

    private GamePieceModel _left;
    private GamePieceModel _top;
    private GamePieceModel _right;
    private GamePieceModel _bottom;	

    public GamePieceModel(Observer observer, PlayerModel player) {
		super(observer);
		_player = player;
	}
	
	public void setLeft(GamePieceModel position) { _left = position; }
    public void setTop(GamePieceModel position) { _top = position; }
    public void setRight(GamePieceModel position) { _right = position; }
    public void setBottom(GamePieceModel position) { _bottom = position; }
    public void setLocked(boolean isLocked) { _isLocked = isLocked; }
    
    public GamePieceModel getNeighbourTop() { return _top; }
    public GamePieceModel getNeighbourBottom() { return _bottom; }
    public GamePieceModel getNeighbourLeft() { return _left; }
    public GamePieceModel getNeighbourRight() { return _right; }
    public boolean getIsLocked() { return _isLocked; }
    
}