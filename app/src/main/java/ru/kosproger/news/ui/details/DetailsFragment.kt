package ru.kosproger.news.ui.details

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.URLUtil
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import ru.kosproger.news.databinding.FragmentDetailsBinding
import ru.kosproger.news.models.Article

@AndroidEntryPoint
class DetailsFragment : Fragment() {

    private var _binding: FragmentDetailsBinding? = null
    private val mBinding get() = _binding!!
    private val viewModel by viewModels<DetailsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Получение объекта Article из Bundle
        val articleArg = arguments?.getSerializable("article") as? Article

        articleArg?.let { article ->
            article.urlToImage?.let {
                Glide.with(this).load(it).into(mBinding.headerImage)
            }
            mBinding.headerImage.clipToOutline = true
            mBinding.articleDetailsTitle.text = article.title
            mBinding.articleDetailsDescriptionText.text = article.description

            mBinding.articleDetailsButton.setOnClickListener {
                try {
                    val url = article.url.takeIf { URLUtil.isValidUrl(it) } ?: "https://google.com"
                    Intent(Intent.ACTION_VIEW, Uri.parse(url)).also {
                        ContextCompat.startActivity(requireContext(), it, null)
                    }
                } catch (e: Exception) {
                    Toast.makeText(context, "The device doesn't have any browser to view the document!", Toast.LENGTH_SHORT).show()
                }
            }

            mBinding.iconFavorite.setOnClickListener{
                viewModel.saveFavoriteArticle(article)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}