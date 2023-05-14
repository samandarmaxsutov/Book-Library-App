package uz.it_school.booklibraryapp.ui.screens.book

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import uz.it_school.booklibraryapp.R
import uz.it_school.booklibraryapp.databinding.FragmentBookAboutBinding
import uz.it_school.booklibraryapp.model.room.entities.BookEntity

class BookAboutScreen : Fragment(R.layout.fragment_book_about) {

    private var _binding: FragmentBookAboutBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBookAboutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private val viewModel: BookAboutScreenViewModel by viewModels()

    private val args: BookAboutScreenArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.imageViewMain2.setImageResource(
            args.book.image)
        binding.textTitle.text = args.book.title
        binding.locationTxt.text = args.book.title
        binding.text.text = args.book.description
        viewModel.init(args.book)
        binding.backBtn.setOnClickListener {
            findNavController().navigateUp()
        }
        if (args.book.bookMarks) binding.likeButton.setImageResource(R.drawable.baseline_favorite_24)
        else binding.likeButton.setImageResource(R.drawable.unlike)
        binding.likeButton.setOnClickListener {
            viewModel.update()
        }

        viewModel.getUiChange.observe(viewLifecycleOwner){

            binding.imageViewMain2.setImageResource(it.image)
            binding.textTitle.text = it.title
            binding.locationTxt.text = it.title
            binding.text.text = it.description
            if (it.bookMarks) binding.likeButton.setImageResource(R.drawable.baseline_favorite_24)
            else binding.likeButton.setImageResource(R.drawable.unlike)

        }

    }
}