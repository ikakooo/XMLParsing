package com.example.xmlparsing


import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.xmlparsing.models.Channel
import com.example.xmlparsing.models.Money
import kotlinx.android.synthetic.main.list_item_exchange_info.view.*

class ExchangeRatesAdapter(
    private val list: MutableList<Channel>,
    private val exchangesTablesListOfRates: MutableList<Money>
) :
    RecyclerView.Adapter<ExchangeRatesAdapter.ViewHolder>() {

    override fun getItemCount(): Int = exchangesTablesListOfRates.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.list_item_exchange_info, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.onBind()

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private lateinit var model: Money
        private lateinit var globalModel: Channel

        @SuppressLint("SetTextI18n")
        fun onBind() {
            model = exchangesTablesListOfRates[adapterPosition]
            globalModel = list[0]
            itemView.CountryValue_Name_text_view_ID.text = model.CountryValueName
            itemView.abbreviate_text_view_ID.text = model.abbreviate
            itemView.value_text_view_ID.text = "${model.value} GEL"
            itemView.changing_text_view_ID.text = model.changing
            itemView.lastBuildDate_text_view_ID.text = globalModel.lastBuildDate
            Glide.with(itemView.context).load(model.IMGLink)
                .into(itemView.IMGLink_Img_view_ID)

        }
    }

}


//value_text_view_ID
//
//class ExchangeRatesAdapter (
//    private val list: List<Channel>
//) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
//        Log.d("Adapter", "onCreateViewHolder")
//        return if (viewType == USER_INFO) {
//            val view =
//                LayoutInflater.from(parent.context)
//                    .inflate(R.layout.list_item_exchange_info, parent, false)
//            UserInfoViewHolder(view)
//        } else {
//            val view =
//                LayoutInflater.from(parent.context)
//                    .inflate(R.layout.list_item_exchange_info2, parent, false)
//            SecondUserInfoViewHolder(view)
//        }
//    }
//
//    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        Log.d("Adapter", "onBindViewHolder - $position")
//        if (holder is UserInfoViewHolder) {
//            holder.setContent(list[position])
//        } else if (holder is SecondUserInfoViewHolder) {
//            holder.setContent(list[position])
//        }
//    }
//
//    override fun getItemCount(): Int {
//        Log.d("Adapter", "getItemCount")
//        return list.size
//    }
//
//    override fun getItemViewType(position: Int): Int {
//        return if (position % 2 == 0) USER_INFO else SECOND_USER_INFO
//    }
//
//    companion object {
//
//        private const val USER_INFO = 1
//        private const val SECOND_USER_INFO = 2
//
//    }
//
//}
//
//class UserInfoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//
//    private val nameTextView = itemView.findViewById<TextView>(R.id.name_text_view)
//    private val ageTextView = itemView.findViewById<TextView>(R.id.age_text_view)
//
//    fun setContent(userInfo: Channel) {
//        with(userInfo) {
//            nameTextView.text = title
//            ageTextView.text = link.toString()
//        }
//    }
//
//}
//
//class SecondUserInfoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//
//    private val nameTextView = itemView.findViewById<TextView>(R.id.first_name_text_view)
//    private val ageTextView = itemView.findViewById<TextView>(R.id.age_text_viewID)
//
//    fun setContent(userInfo: Channel) {
//        with(userInfo) {
//            nameTextView.text = title
//            ageTextView.text = link.toString()
//        }
//    }
//
//}