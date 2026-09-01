package bo.edu.uajms.marianagutierrez.a2026_tresenraya

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity: AppCompatActivity()
{
    private lateinit var BTNTablero:Array<Button>
    private lateinit var TXVPlayer: TextView
    private lateinit var BTNRestart: Button
    private lateinit var Tablero:Array<Array<String>>

    private val rows=3
    private val cols=3
    private var currentPlayer=0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        BTNTablero = arrayOf(
            findViewById(R.id.BTN00),
            findViewById(R.id.BTN01),
            findViewById(R.id.BTN02),
            findViewById(R.id.BTN10),
            findViewById(R.id.BTN11),
            findViewById(R.id.BTN12),
            findViewById(R.id.BTN20),
            findViewById(R.id.BTN21),
            findViewById(R.id.BTN22)
        )

        TXVPlayer= findViewById(R.id.TXVPlayer)
        BTNRestart=findViewById(R.id.BTNRestart)

        Tablero= Array( size=rows){ Array (size=cols){""} }

        for (i in BTNTablero.indices)
        {
            val row = i / rows
            val col = i % cols
            BTNTablero[i].setOnClickListener()
            {
                Log.d("Click",  "Hiciste click en ($row,$col)")
                click(row,col,BTNTablero[i])
            }
        }

        BTNRestart.setOnClickListener()
        {
            Log.d("Click",  "Hiciste click en Reiniciar")
        }
    }

    private fun click(row: Int, col: Int, button: Button) {
        if (button.text=="") {
            if (currentPlayer == 0) {
                button.setText("0")
                currentPlayer = 1
                Tablero[row][col]="0"
                TXVPlayer.setText(getString(R.string.playerX))
            } else {
                button.setText("X")
                currentPlayer = 0
                Tablero[row][col]="X"
                TXVPlayer.setText(getString(R.string.player0))
            }
            verifyVictory()

        }
        }

    private fun verifyVictory() {
        if (verifyCols() || verifyRows() || verifyDiagonals())
        {
            if (currentPlayer == 0)
            {
                TXVPlayer.setText(getString(R.string.playerXwin))
            }
            else
            {
                TXVPlayer.setText(getString(R.string.player0win))
            }
        }
    }
    private fun verifyCols(): Boolean
    {
        for (i in 0 ..< rows)
        {
            if (Tablero[i][0] == Tablero[i][1] && Tablero[i][0] == Tablero[i][2]&& Tablero[0][i] != "")
            {
                return true
            }
        }
        return false
    }

    private fun verifyRows(): Boolean
    {
        for (i in 0 ..< rows)
        {
            if (Tablero[i][0] == Tablero[i][1] && Tablero[i][0] == Tablero[i][2]&& Tablero[0][i] != "")
            {
                return true
            }
        }
        return false
    }

    private fun verifyDiagonals(): Boolean
    {
        if ((Tablero[0][0] == Tablero[1][1] && Tablero[0][0] == Tablero[2][2]&& Tablero[0][0] != "") ||
            (Tablero[0][2] == Tablero[1][1] && Tablero[0][2] == Tablero[2][0]&& Tablero[0][2] != ""))
        {
            return true
        }
        return true
    }
}