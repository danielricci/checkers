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

package engine.controllers;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

import engine.models.player.PlayerModel;
import engine.models.tiles.GameTileModel;

public class BoardGameController extends BaseController {

	private final Vector<GameTileModel> _tiles = new Vector<GameTileModel>();
	private final Queue<PlayerModel> _turns = new LinkedList<PlayerModel>();
	
	public BoardGameController() {
		
		/*
		for (PlayerModel player : _players) {
			_turns.add(player);
		}
		*/
	}
		
/*
	public boolean isWinningPosition(BoardPosition position, List<BoardPosition> positions) {

		boolean result = isWinningRow(position, positions) || isWinningColumn(position, positions)
				|| isWinningDiagonal(position, positions);

		positions.add(position);

		return result;
	}

	public boolean isGameOver() {
		return _isGameOver;
	}

	private boolean isWinningRow(BoardPosition position, List<BoardPosition> positions) {

		positions.clear();
		int rowSize = _gridSize - 1;

		BoardPosition temp = position;
		while ((temp = temp.getNeighbourLeft()) != null && temp.equals(position)) {
			positions.add(temp);
			--rowSize;
		}

		temp = position;
		while ((temp = temp.getNeighbourRight()) != null && temp.equals(position)) {
			positions.add(temp);
			--rowSize;
		}

		assert rowSize > -1 : "Winning position invalid, something went wrong with the grid size";
		return rowSize == 0;
	}

	private boolean isWinningColumn(BoardPosition position, List<BoardPosition> positions) {

		positions.clear();
		int colSize = _gridSize - 1;

		BoardPosition temp = position;
		while ((temp = temp.getNeighbourTop()) != null && temp.equals(position)) {
			positions.add(temp);
			--colSize;
		}

		temp = position;
		while ((temp = temp.getNeighbourBottom()) != null && temp.equals(position)) {
			positions.add(temp);
			--colSize;
		}

		assert colSize > -1 : "Winning position invalid, something went wrong with the grid size";
		return colSize == 0;
	}

	private boolean isWinningDiagonal(BoardPosition position, List<BoardPosition> positions) {

		positions.clear();
		int colSize = _gridSize - 1;
		BoardPosition temp = position;

		while ((temp = temp.getNeighbourTop()) != null && (temp = temp.getNeighbourRight()) != null
				&& temp.equals(position)) {
			positions.add(temp);
			--colSize;
		}

		temp = position;
		while ((temp = temp.getNeighbourBottom()) != null && (temp = temp.getNeighbourLeft()) != null
				&& temp.equals(position)) {
			positions.add(temp);
			--colSize;
		}

		if (colSize > 0) {
			positions.clear();
			colSize = _gridSize - 1;
			temp = position;

			while ((temp = temp.getNeighbourTop()) != null && (temp = temp.getNeighbourLeft()) != null
					&& temp.equals(position)) {
				positions.add(temp);
				--colSize;
			}

			temp = position;
			while ((temp = temp.getNeighbourBottom()) != null && (temp = temp.getNeighbourRight()) != null
					&& temp.equals(position)) {
				positions.add(temp);
				--colSize;
			}
		}

		return colSize == 0;
	}

	public String getPlayerToken() {
		return _turns.peek().getTokenPath();
	}

	public PlayerModel getCurrentPlayer() {
		return _turns.peek();
	}

	/*
	private void nextPlayer() {
		_turns.add(_turns.poll());
	}
	*/


	/*
	  	public int getGridSize() {
		return _gridSize;
	}
	
	public void performMove(java.awt.event.InputEvent event) {

		List<BoardPosition> winningPositions = new ArrayList<BoardPosition>();

		if (!(_isGameOver || isWinningPosition((BoardPosition) event.getSource(), winningPositions))) {
			nextPlayer();
		} else {

			_isGameOver = true;
			getCurrentPlayer().incrementWins();

			for (PlayerModel model : _players) {
				System.out.println(model.toString());
			}

			for (BoardPosition position : winningPositions) {
				position.setBackground(Color.RED);
			}
		}
	}
	*/
}