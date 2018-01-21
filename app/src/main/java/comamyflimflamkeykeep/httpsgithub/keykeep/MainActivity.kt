package comamyflimflamkeykeep.httpsgithub.keykeep

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.*
import java.security.KeyPairGenerator


class MainActivity : Activity(), View.OnClickListener {
    override fun onClick(p0: View?) {
        val text = findViewById<TextView>(R.id.da_text)
        text.text = "HIIII"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button_create_key)
        val list = findViewById<ListView>(R.id.listMain)
        val x = listOf("")
        list.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, x)

        button.text = "generate key"
        button.setOnClickListener(ListViewThingo(this))
    }
}

class ListViewThingo(activity: Activity) : View.OnClickListener {
    var act: Activity = activity

    override fun onClick(p0: View?) {
        val list = act.findViewById<ListView>(R.id.listMain)
        val x = listOf(generateKey())
        list.adapter = ArrayAdapter(act, android.R.layout.simple_list_item_1, x)
        list.deferNotifyDataSetChanged()
    }
}

fun generateKey(): String {
    fun ClosedRange<Int>.random() =
            java.util.Random().nextInt(endInclusive - start) +  start

    val keyPair = KeyPairGenerator.getInstance("RSA").genKeyPair()
    return keyPair.private.toString()
}