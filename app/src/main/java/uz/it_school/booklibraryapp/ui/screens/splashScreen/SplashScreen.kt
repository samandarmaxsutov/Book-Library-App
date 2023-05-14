package uz.it_school.booklibraryapp.ui.screens.splashScreen

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import uz.it_school.booklibraryapp.R
import uz.it_school.booklibraryapp.databinding.FragmentSplashScreenBinding


@SuppressLint("CustomSplashScreen")
class SplashScreen : Fragment(R.layout.fragment_splash_screen) {

    private var _binding: FragmentSplashScreenBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentSplashScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private  val viewModel: SplashScreenViewModel by viewModels ()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.openMainScreenLiveData.observe(this){
            findNavController().navigate(SplashScreenDirections.actionSplashScreenToHomeScreen())
        }
    }

}