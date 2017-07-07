package com.example.dopy.facebook;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.dopy.facebook.data_model.Friend;
import com.example.dopy.facebook.data_model.FriendList;
import com.example.dopy.facebook.data_model.Items;
import com.example.dopy.facebook.data_model.Message;
import com.example.dopy.facebook.data_model.MessageList;
import com.example.dopy.facebook.data_model.News;
import com.example.dopy.facebook.data_model.NewsList;

import butterknife.BindView;
import butterknife.ButterKnife;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
**/

public class TimeLine_fragment extends Fragment {
    @BindView(R.id.newsfeedRecyclerView)
    RecyclerView newsRecyclerView;

    List<Items> ItemsList;
    public TimeLine_fragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_newsfeed, container, false);
    }

    //액티비티에서 프래그먼트를 모두 생성하고 나서 호출되는 메소드로 뷰를 건들려면 여기서 해야한다.
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);

        newsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayout.VERTICAL,false));
        newsRecyclerView.setAdapter(new TimeLineAdapter(setUpData(), getActivity(), new ItemClickedListener() {
            @Override
            public void Click(String msg) {
                Toast.makeText(getActivity(),msg,Toast.LENGTH_LONG).show();
            }}));
    }

    public static TimeLine_fragment newInstance(){
        Bundle args = new Bundle();
        TimeLine_fragment fragment=new TimeLine_fragment();
        fragment.setArguments(args);
        return fragment;
    }

    public static final int FRIEND_VIEW_TYPE=101;
    public static final int MESSAGE_VIEW_TYPE=102;
    public static final int NEWS_VIEW_TYPE=103;
    public List<Items> setUpData(){
        ItemsList=new ArrayList<>();
        ItemsList.add(new FriendList(FRIEND_VIEW_TYPE,setUpFriendsData()));
        ItemsList.add(new MessageList(MESSAGE_VIEW_TYPE,setUpMessageData()));
        ItemsList.add(new NewsList(NEWS_VIEW_TYPE,setUpNewsType()));

        return ItemsList;
    }

    public List<Friend> setUpFriendsData(){
        List<Friend> friendLists=new ArrayList<>();
        friendLists.add(new Friend(201,"카메라"));
        friendLists.add(new Friend(202,"이지건"));
        friendLists.add(new Friend(202,"문경현"));
        friendLists.add(new Friend(202,"김준영"));
        friendLists.add(new Friend(202,"나영열"));
        friendLists.add(new Friend(202,"정순호"));
        friendLists.add(new Friend(202,"최진주"));
        return friendLists;
    }

    public List<Message> setUpMessageData(){
        List<Message> messageList=new ArrayList<>();
        messageList.add(new Message("무슨 생각을 하고 계신가요?"));
        messageList.add(new Message("당신의 의견을 올려주세요"));
        return messageList;
    }

    public List<News> setUpNewsType(){
        List<News> NewsList=new ArrayList<>();
        return NewsList;
    }
}
