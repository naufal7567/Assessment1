package org.d3if1022.bmi


import android.content.ActivityNotFoundException
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.core.app.ShareCompat
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.fragment_menu.*
import org.d3if1022.bmi.databinding.FragmentMenuBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class MenuFragment : Fragment() {
    var beratFix = 0
    var tinggiFix = 0
    var nilaiBMI = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentMenuBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_menu, container, false)

        binding.hitung.setOnClickListener{
            hitungBerat()
        }

        binding.saran.setOnClickListener{
                v: View ->
            v.findNavController().navigate(MenuFragmentDirections.action_menuFragment_to_normalFragment))
        }

        binding.bagikan.setOnClickListener{
            onShare()
        }

        setHasOptionsMenu(true)
        return binding.root
    }

    private fun onShare() {
        val shareIntent = ShareCompat.IntentBuilder.from(this)
            .setText("naufal7567@gmail.com")
            .setType("text/plain")
            .intent
        try {
            startActivity(shareIntent)
        } catch (ex: ActivityNotFoundException) {
            Toast.makeText(this, "Gagal",
                Toast.LENGTH_LONG).show()
        }
    }

    private fun onKurus(){

    }

    private fun onGemuk(){

    }

    private fun hitungBerat(){
        if (kelamin == pria){
            beratFix = berat.text()
            tinggiFix = tinggi.text : 100
            nilaiBMI = beratFix/(tinggiFix*tinggiFix)

            if (nilaiBMI < 20.50){
                hasil_BMI.setText("Nilai BMI = "+nilaiBMI)
                parameter.setText("KURUS")
            }
            if (nilaiBMI >= 20.50 && nilaiBMI <= 26.99){
                hasil_BMI.setText("Nilai BMI = "+nilaiBMI)
                parameter.setText("IDEAL")
            }
            else{
                hasil_BMI.setText("Nilai BMI = "+nilaiBMI)
                parameter.setText("GEMUK")
            }
        }
        else{
            beratFix = berat.text()
            tinggiFix = tinggi.text : 100
            nilaiBMI = beratFix/(tinggiFix*tinggiFix)

            if (nilaiBMI < 18.50){
                hasil_BMI.setText("Nilai BMI = "+nilaiBMI)
                parameter.setText("KURUS")
            }
            if (nilaiBMI >= 18.50 && nilaiBMI <= 24.99){
                hasil_BMI.setText("Nilai BMI = "+nilaiBMI)
                parameter.setText("IDEAL")
            }
            else{
                hasil_BMI.setText("Nilai BMI = "+nilaiBMI)
                parameter.setText("GEMUK")
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!,
            view!!.findNavController())
                || super.onOptionsItemSelected(item)
    }
}
