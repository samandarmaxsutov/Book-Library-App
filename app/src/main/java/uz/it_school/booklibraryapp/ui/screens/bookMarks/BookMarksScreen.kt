package uz.it_school.booklibraryapp.ui.screens.bookMarks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import uz.it_school.booklibraryapp.R
import uz.it_school.booklibraryapp.databinding.FragmentBookMarketsBinding
import uz.it_school.booklibraryapp.ui.adapters.BookAdapter

class BookMarksScreen : Fragment(R.layout.fragment_book_markets) {

    private var _binding: FragmentBookMarketsBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBookMarketsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private val viewModel: BookMarksViewModel by viewModels()
    private val adapter= BookAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val layoutManager = GridLayoutManager(requireContext(), 2)
        binding.list.layoutManager = layoutManager
        binding.list.adapter=adapter
        viewModel.countriesLiveData.observe(viewLifecycleOwner){
            adapter.submitItems(it)
        }
        adapter.onClick{viewModel.open(it)}

        binding.backBtn.setOnClickListener { findNavController().navigateUp() }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.openCountryScreenLiveData.observe(this){
            findNavController().navigate(BookMarksScreenDirections.actionBookMarksScreenToBookAboutScreen(it))
        }
    }
}