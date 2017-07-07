package com.example.dopy.facebook;

import android.content.ClipData;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dopy.facebook.data_model.Friend;
import com.example.dopy.facebook.data_model.FriendList;
import com.example.dopy.facebook.data_model.Items;
import com.example.dopy.facebook.data_model.Message;
import com.example.dopy.facebook.data_model.MessageList;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dlwlr on 2017-07-06.
 */
interface ItemClickedListener{
    void Click(String msg);
}

public class TimeLineAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<Items> ItemList;
    Context context;
    ItemClickedListener listener;

    public static final int FRIEND_VIEW_TYPE=101;
    public static final int MESSAGE_VIEW_TYPE=102;
    public static final int NEWS_VIEW_TYPE=103;

    public TimeLineAdapter(List<Items> itemList, Context context, ItemClickedListener listener) {
        ItemList = itemList;
        this.context = context;
        this.listener = listener;
        Log.d("TimeLineAdapter","Create TimeLineAdapter");
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case FRIEND_VIEW_TYPE:
                Log.d("TimeLineAdapter","FRIEND_VIEW_TYPE");
                return new Friends_RCV_View_Holder(LayoutInflater.from(context).inflate(R.layout.friends_recycler_view,parent,false),context);
            case MESSAGE_VIEW_TYPE:
                Log.d("TimeLineAdapter","MESSAGE_VIEW_TYPE");

                return new MessageRcvViewHolder(LayoutInflater.from(context).inflate(R.layout.message_recycler_view,parent,false),context);
                //return new MessageViewHolder(LayoutInflater.from(context).inflate(R.layout.message,parent,false),context);
            case NEWS_VIEW_TYPE:
                Log.d("TimeLineAdapter","NEWS_VIEW_TYPE");

                return new NewsViewholder(LayoutInflater.from(context).inflate(R.layout.news,parent,false),context);
            default:
                Log.d("TimeLineAdapter","okokok");
                break;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)){
            case FRIEND_VIEW_TYPE:
                Log.d("TimeLineAdapter","onBindViewHolder-FRIEND_VIEW_TYPE");
                ((Friends_RCV_View_Holder) holder).BindView(ItemList.get(position),listener);
                break;
            case MESSAGE_VIEW_TYPE:
                Log.d("TimeLineAdapter","onBindViewHolder-MESSAGE_VIEW_TYPE");
                ((MessageRcvViewHolder) holder).BindView(ItemList.get(position),listener);

                break;
            case NEWS_VIEW_TYPE:
                ((NewsViewholder) holder).BindView(ItemList.get(position),listener);
                break;
        }
    }
    public int getItemViewType(int position) {
        Log.d("TimeLineAdapter","viewType: " + String.valueOf(ItemList.get(position).getViewType()) + " Position: " + String.valueOf(position));
        return ItemList.get(position).getViewType();
    }

    @Override
    public int getItemCount() {
        Log.d("TimeLineAdapter","size: " + String.valueOf(ItemList.size()));
        return ItemList.size();
    }

    abstract class  baseViewHolder extends RecyclerView.ViewHolder{
        Context context;

        public baseViewHolder(View itemView, Context context) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            this.context = context;
        }
        abstract public void BindView(Items items,ItemClickedListener listener);
    }
    class NewsViewholder extends baseViewHolder{

        public NewsViewholder(View itemView, Context context) {
            super(itemView, context);
        }

        @Override
        public void BindView(Items items, ItemClickedListener listener) {

        }
    }

    class Friends_RCV_View_Holder extends baseViewHolder{
        @BindView(R.id.rcv_friends)
        RecyclerView rcv_Friends;

        public Friends_RCV_View_Holder(View itemView, Context context) {
            super(itemView, context);
            ButterKnife.bind(this,itemView);
            Log.d("Friends_RCV_View_Holder","CreatedViewHolder");
        }

        @Override
        public void BindView(Items items, ItemClickedListener listener) {
            Log.d("Friends_RCV_View_Holder","BindView");
            rcv_Friends.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
            rcv_Friends.setAdapter(new Friend_Adapter(((FriendList) items).getFriendList(),context,listener));
        }
    }

    class Friend_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
        List<Friend> friendList;
        Context context;
        ItemClickedListener listener;

        public static final int CAMERA_ICON=201;
        public static final int FRIEND_ICON=202;

        public Friend_Adapter(List<Friend> friendList, Context context, ItemClickedListener listener) {
            this.friendList = friendList;
            this.context = context;
            this.listener = listener;
        }
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Log.d("Friends_RCV_View_Holder","onCreateViewHolder");
            return new Friend_ViewHolder(LayoutInflater.from(context).inflate(R.layout.new_firend,parent,false),context);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            Log.d("Friends_RCV_View_Holder","onBindViewHolder");
            ((Friend_ViewHolder) holder).BindView(friendList.get(position),listener);
        }
        @Override
        public int getItemCount() {
            return friendList.size();
        }
    }

    class Friend_ViewHolder extends baseViewHolder{
        @BindView(R.id.containerCamera)
        RelativeLayout containerCamera;
        @BindView(R.id.containerFriend)
        RelativeLayout containerFriend;
        @BindView(R.id.txtvName)
        TextView txtName;

        public static final int CAMERA=201;
        public static final int FRIEND=202;

        public Friend_ViewHolder(View itemView,Context context) {
            super(itemView,context);
            ButterKnife.bind(this.itemView);
            Log.d("Friend_ViewHolder","Created");
        }
        private void setINVISIBLE_Container(){
            containerCamera.setVisibility(View.INVISIBLE);
            containerFriend.setVisibility(View.INVISIBLE);
        }

        @Override
        public void BindView(Items items, ItemClickedListener listener) {

        }

        public void BindView(Friend items, final ItemClickedListener listener) {
            //setINVISIBLE_Container();
            switch (items.getType()){
                case 201:
                    containerCamera.setVisibility(View.VISIBLE);
                    containerCamera.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            listener.Click("카메라 버튼 클릭됨");
                        }});
                    Log.d("Friend_ViewHolder","addCAMERA");

                    break;
                case 202:
                    containerFriend.setVisibility(View.VISIBLE);
                    txtName.setText(items.getName());
                    containerFriend.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            listener.Click(txtName.getText()+"님을 친구등록 할까요?");
                        }});
                    Log.d("Friend_ViewHolder","addFriend");
                    break;
            }
        }
    }

    class MessageRcvViewHolder extends baseViewHolder{
        @BindView(R.id.rcv_Message)
        RecyclerView rcv_Message;

        public MessageRcvViewHolder(View itemView, Context context) {
            super(itemView, context);
            ButterKnife.bind(this,itemView);
        }

        @Override
        public void BindView(Items items, ItemClickedListener listener) {
            rcv_Message.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
            rcv_Message.setAdapter(new MessageAdapter(((MessageList) items).getMessageList(),context,listener));
        }
    }
    class MessageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
        List<Message> messageList;
        Context context;
        ItemClickedListener listener;

        public MessageAdapter(List<Message> messageList, Context context, ItemClickedListener listener) {
            this.messageList = messageList;
            this.context = context;
            this.listener = listener;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MessageViewHolder(LayoutInflater.from(context).inflate(R.layout.message,parent,false),context);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ((MessageViewHolder) holder).BindView(messageList.get(position),listener);
        }

        @Override
        public int getItemCount() {
            return messageList.size();
        }
    }

    class MessageViewHolder extends baseViewHolder{
        @BindView(R.id.textMessage)
        TextView textView;

        public MessageViewHolder(View itemView, Context context) {
            super(itemView, context);
            ButterKnife.bind(this,itemView);
        }
        @Override
        public void BindView(Items items, ItemClickedListener listener) {
        }
        public void BindView(Message items ,ItemClickedListener listener){
            textView.setText(items.getMeg());
        }
    }

}
