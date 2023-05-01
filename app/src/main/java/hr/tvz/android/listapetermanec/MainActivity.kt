package hr.tvz.android.listapetermanec

import android.content.Intent
import android.content.IntentFilter
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import hr.tvz.android.listapetermanec.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val recyclerView = binding.recycler
        recyclerView.setHasFixedSize(true)

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        val adapter = AdapterRecyclerView(resources.getStringArray(R.array.exercises))
        recyclerView.adapter = adapter

        val filter = IntentFilter()
        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        val receiver = Receiver(baseContext)
        registerReceiver(receiver, filter)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.activity_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.share -> showDialog()
            R.id.web -> startActivity(
                Intent(
                    Intent.ACTION_VIEW, Uri.parse("https://www.fitnotesapp.com")
                )
            )
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showDialog() {
        val builder = AlertDialog.Builder(this)
        with(builder) {
            setTitle(R.string.share_message)
            setMessage(R.string.share_message)
            setPositiveButton(
                R.string.yes
            ) { _, _ -> sendBroadcast(Intent().setAction("hr.tvz.android.broadcast")) }
            setNegativeButton(R.string.no) { _, _ -> }
            show()
        }
    }
}