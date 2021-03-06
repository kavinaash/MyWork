package com.example.crypsis.send;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NavigationDraw extends AppCompatActivity {
    List<ConversationListInfoModel> cinfo = new ArrayList<>();
    DrawerLayout drawerLayout;
    ListView listView;
    ActionBarDrawerToggle actionBarDrawerToggle;
    String string = "";Number number;ConversationListInfoModel m;
    LinearLayout linearLayout;
    EditText invite, addphone, awaymessagetext;
    String id, firstName, lastName, phoneNumber, email, shortName, message;
    Dialog addCustomerPhone, invitationDialog, customerSearchDialog, addCustomer, cannedResponses, awayMessages;
    Retrofit retrofit;
    TextView textView;
    static final int SELECTED_PICTURE = 2;
    static final int CONVERSATION_LIST=3;
    ImageView imageView;
    EditText e1, e2, e3, e4, e5, e6;
    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    Switch aSwitch, aSwitch2, aSwitch3;
    boolean subscribed, shared, status;
    String msg, s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14;
    Spinner spinner1, spinner2, spinner3, spinner4, spinner5, spinner6, spinner7, spinner8, spinner9, spinner10, spinner11, spinner12, spinner13, spinner14;
    ArrayAdapter<String> arrayAdapterr, arrayAdapter1;
    RecyclerView recyclerView;
    MyRecyclerViewAdapter myRecyclerViewAdapter;
    private Socket mSocket;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navdrawer);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.menu);
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.122:3001/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
//        showList();


        try {
            mSocket = IO.socket("http://192.168.0.135:3000/");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        mSocket.connect();
        mSocket.on("load_old_messages", onNewMessage);
        Log.d("test", "is connected:" + mSocket.connected());
        mSocket.emit("new_user", "avinaash");



        string = (String) getTitle();
        arrayAdapterr = new ArrayAdapter<String>(this, R.layout.text);
        arrayAdapter1 = new ArrayAdapter<String>(this, R.layout.text);
        arrayAdapterr.add("7:00 AM");
        arrayAdapterr.add("8:00 AM");
        arrayAdapterr.add("9:00 AM");
        arrayAdapterr.add("10:00 AM");
        arrayAdapterr.add("11:00 AM");
        arrayAdapterr.add("12:00 PM");
        arrayAdapterr.add("1:00 PM");
        arrayAdapterr.add("2:00 PM");
        arrayAdapterr.add("3:00 PM");
        arrayAdapterr.add("4:00 PM");
        arrayAdapterr.add("5:00 PM");
        arrayAdapterr.add("6:00 PM");
        arrayAdapterr.add("7:00 PM");
        arrayAdapterr.add("8:00 PM");
        arrayAdapterr.add("9:00 PM");
        arrayAdapterr.add("10:00 PM");
        arrayAdapterr.add("11:00 PM");
        arrayAdapterr.add("12:00 AM");
        arrayAdapterr.add("1:00 AM");
        arrayAdapterr.add("2:00 AM");
        arrayAdapterr.add("3:00 AM");
        arrayAdapterr.add("4:00 AM");
        arrayAdapterr.add("5:00 AM");
        arrayAdapterr.add("6:00 AM");

        arrayAdapter1.add("5:00 PM");
        arrayAdapter1.add("6:00 PM");
        arrayAdapter1.add("7:00 PM");
        arrayAdapter1.add("8:00 PM");
        arrayAdapter1.add("9:00 PM");
        arrayAdapter1.add("10:00 PM");
        arrayAdapter1.add("11:00 PM");
        arrayAdapter1.add("12:00 AM");
        arrayAdapter1.add("1:00 AM");
        arrayAdapter1.add("2:00 AM");
        arrayAdapter1.add("3:00 AM");
        arrayAdapter1.add("4:00 AM");
        arrayAdapter1.add("5:00 AM");
        arrayAdapter1.add("6:00 AM");
        arrayAdapter1.add("7:00 AM");
        arrayAdapter1.add("8:00 AM");
        arrayAdapter1.add("9:00 AM");
        arrayAdapter1.add("10:00 AM");
        arrayAdapter1.add("11:00 AM");
        arrayAdapter1.add("12:00 PM");
        arrayAdapter1.add("1:00 PM");
        arrayAdapter1.add("2:00 PM");
        arrayAdapter1.add("3:00 PM");
        arrayAdapter1.add("4:00 PM");


        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        listView = (ListView) findViewById(R.id.left_drawer);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.drawable.menu, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerClosed(View drawerView) {
                getSupportActionBar().setTitle(string);
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                getSupportActionBar().setTitle("Select a Planet");
                invalidateOptionsMenu();
            }
        };
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.drawer_list_item, getResources().getStringArray(R.array.planets_array));
        listView.setAdapter(arrayAdapter);
        ActionBar actionBar = getSupportActionBar();

        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String[] planets = getResources().getStringArray(R.array.planets_array);
                string = planets[position];
                switch (position) {
                    case 0:
                        invitationDialog = new Dialog(NavigationDraw.this);
                        invitationDialog.setContentView(R.layout.invite_team_members);
                        invitationDialog.show();
                        break;
                    case 1:
                        Dialog d1 = new Dialog(NavigationDraw.this);
                        d1.setContentView(R.layout.customers_search);
                        d1.show();

                        break;
                    case 2:
                        cannedResponses = new Dialog(NavigationDraw.this);
                        cannedResponses.setContentView(R.layout.canned_responses);
                        cannedResponses.show();
                        break;
                    case 3:
                        awayMessages = new Dialog(NavigationDraw.this);
                        awayMessages.setContentView(R.layout.away_messages);
                        awayMessages.show();
                        spinner1 = (Spinner) awayMessages.findViewById(R.id.spinner);
                        spinner2 = (Spinner) awayMessages.findViewById(R.id.spinner2);
                        spinner3 = (Spinner) awayMessages.findViewById(R.id.spinner3);
                        spinner4 = (Spinner) awayMessages.findViewById(R.id.spinner4);
                        spinner5 = (Spinner) awayMessages.findViewById(R.id.spinner5);
                        spinner6 = (Spinner) awayMessages.findViewById(R.id.spinner6);
                        spinner7 = (Spinner) awayMessages.findViewById(R.id.spinner7);
                        spinner8 = (Spinner) awayMessages.findViewById(R.id.spinner8);
                        spinner9 = (Spinner) awayMessages.findViewById(R.id.spinner9);
                        spinner10 = (Spinner) awayMessages.findViewById(R.id.spinner10);
                        spinner11 = (Spinner) awayMessages.findViewById(R.id.spinner11);
                        spinner12 = (Spinner) awayMessages.findViewById(R.id.spinner12);
                        spinner13 = (Spinner) awayMessages.findViewById(R.id.spinner13);
                        spinner14 = (Spinner) awayMessages.findViewById(R.id.spinner14);
                        spinner1.setAdapter(arrayAdapterr);
                        spinner2.setAdapter(arrayAdapter1);
                        spinner3.setAdapter(arrayAdapterr);
                        spinner4.setAdapter(arrayAdapter1);
                        spinner5.setAdapter(arrayAdapterr);
                        spinner6.setAdapter(arrayAdapter1);
                        spinner7.setAdapter(arrayAdapterr);
                        spinner8.setAdapter(arrayAdapter1);
                        spinner9.setAdapter(arrayAdapterr);
                        spinner10.setAdapter(arrayAdapter1);
                        spinner11.setAdapter(arrayAdapterr);
                        spinner12.setAdapter(arrayAdapter1);
                        spinner13.setAdapter(arrayAdapterr);
                        spinner14.setAdapter(arrayAdapter1);
                        break;


                    default:
                        Toast.makeText(NavigationDraw.this, "hello2", Toast.LENGTH_SHORT).show();

                }
//                PlanetFragment planetFragment=new PlanetFragment();
//                Bundle bundle=new Bundle();
//                bundle.putInt("position", position);
//                planetFragment.setArguments(bundle);
//                FragmentManager fragmentManager=getFragmentManager();
//                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.content_frame,planetFragment);
//                fragmentTransaction.commit();
                drawerLayout.closeDrawer(listView);
            }
        });


        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("New"));
        tabLayout.addTab(tabLayout.newTab().setText("Mine"));
        tabLayout.addTab(tabLayout.newTab().setText("All"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setTabTextColors(-16777216, -16777216);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }

    private Emitter.Listener onNewMessage = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {
            NavigationDraw.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    JSONArray jsonArray = (JSONArray) args[0];
                    for (int i = 0; i < jsonArray.length(); i++) {
                        try {
                            JSONObject m = jsonArray.getJSONObject(i);
                            ConversationListInfoModel conversationListInfoModel = new ConversationListInfoModel();

                            conversationListInfoModel.firstName = m.getString("firstName");
                            conversationListInfoModel.lastMessage = m.getString("lastMessage");
                            conversationListInfoModel.fbid = m.getLong("fbid");
                            cinfo.add(conversationListInfoModel);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    myRecyclerViewAdapter = new MyRecyclerViewAdapter(cinfo, new CallBack() {
                        @Override
                        public void onItemClick(int position) {
                             m= myRecyclerViewAdapter.getItem(position);
                            number = m.getFbid();
                            mSocket.emit("id", number);
                            Intent intent = new Intent(NavigationDraw.this, ChatActivity.class);
                            startActivityForResult(intent,CONVERSATION_LIST);
                        }
                    });
                    recyclerView.setAdapter(myRecyclerViewAdapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(NavigationDraw.this));

                }
            });
        }
    };

    @Override
    public void onDestroy() {
        super.onDestroy();

        mSocket.disconnect();
        mSocket.off("load old messages", onNewMessage);
    }

    public static <S> S createService(Class<S> serviceClass) {
        Retrofit retrofit = new Retrofit.Builder().client(httpClient.build()).build();
        return retrofit.create(serviceClass);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        int id = item.getItemId();

        if (id == R.id.addPhone) {
            addCustomerPhone = new Dialog(NavigationDraw.this);
            addCustomerPhone.setContentView(R.layout.dialog);
            addCustomerPhone.show();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        boolean drawerOpen = drawerLayout.isDrawerOpen(listView);
        menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }

    public void invite(View v) {


        invite = (EditText) invitationDialog.findViewById(R.id.invitemember);
        id = invite.getText().toString();
        InviteTeamMember inviteTeamMember = new InviteTeamMember("email", id);

        FileUploadInterface fileUploadInterface = retrofit.create(FileUploadInterface.class);

        Call<InviteTeamMember> call = fileUploadInterface.invite(inviteTeamMember);
        call.enqueue(new Callback<InviteTeamMember>() {
            @Override
            public void onResponse(Call<InviteTeamMember> call, Response<InviteTeamMember> response) {
                Toast.makeText(getApplicationContext(), "success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<InviteTeamMember> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "fail", Toast.LENGTH_SHORT).show();
            }
        });
        invitationDialog.dismiss();
    }

    public void addCustomerNumber(View v) {


        addphone = (EditText) addCustomerPhone.findViewById(R.id.phone);
        id = addphone.getText().toString();
        AddCustomerPhoneNumber addCustomerPhoneNumber = new AddCustomerPhoneNumber("phone", id);

        FileUploadInterface fileUploadInterface = retrofit.create(FileUploadInterface.class);

        Call<AddCustomerPhoneNumber> call = fileUploadInterface.addPhone(addCustomerPhoneNumber);
        call.enqueue(new Callback<AddCustomerPhoneNumber>() {
            @Override
            public void onResponse(Call<AddCustomerPhoneNumber> call, Response<AddCustomerPhoneNumber> response) {
                Toast.makeText(getApplicationContext(), "success", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<AddCustomerPhoneNumber> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "fail", Toast.LENGTH_SHORT).show();

            }
        });

        addCustomerPhone.dismiss();
    }

    public void cancelDialogCustomerSearchAddCustomer(View v) {
        addCustomer.dismiss();
    }

    public void cancelDialogCannedResponses(View view) {
        cannedResponses.dismiss();
    }


    public void cancelDialogAddCustomerPhone(View v) {
        addCustomerPhone.dismiss();
    }

    public void cancelDialogAwayMessages(View v) {
        awayMessages.dismiss();
    }

    public void addCustomer(View v) {
        addCustomer = new Dialog(NavigationDraw.this);
        addCustomer.setContentView(R.layout.customer_search_add_customer);
        addCustomer.show();
    }

    public void addPhoto(View v) {
        textView = (TextView) v.findViewById(R.id.upload);
        SpannableString content = new SpannableString("Uppload");
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        textView.setText(content);
        e1 = (EditText) addCustomer.findViewById(R.id.editTextfirstName);
        e2 = (EditText) addCustomer.findViewById(R.id.editTextlastName);
        e3 = (EditText) addCustomer.findViewById(R.id.editTextphoneNumber);
        e4 = (EditText) addCustomer.findViewById(R.id.editTextemail);
        aSwitch = (Switch) addCustomer.findViewById(R.id.switch1);
        if (aSwitch.isChecked()) {
            subscribed = true;
        }
        firstName = e1.getText().toString();
        lastName = e2.getText().toString();
        phoneNumber = e3.getText().toString();
        email = e4.getText().toString();

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), SELECTED_PICTURE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {


        if (resultCode == RESULT_OK && requestCode==SELECTED_PICTURE) {
            imageView = (ImageView) findViewById(R.id.imageView2);
            imageView.setImageURI(data.getData());
            uploadFile(data.getData(), firstName, lastName, phoneNumber, email, subscribed);
        }
        if(resultCode==RESULT_OK && requestCode==CONVERSATION_LIST)
        {
            String message = data.getExtras().getString("msg");
            Long id = data.getExtras().getLong("id");
            m.lastMessage=message;
            myRecyclerViewAdapter.notifyDataSetChanged();
//            for (ConversationListInfoModel e:cinfo)
//            {
//                if(e.fbid==id)
//                {Toast.makeText(NavigationDraw.this,"found",Toast.LENGTH_SHORT).show();
//                    e.lastMessage=message;myRecyclerViewAdapter.notifyDataSetChanged();
//                }
//            }

        }
    }

    public Uri getFilePathByUri(Uri uri) {
        Uri filePathUri = uri;
        if (uri.getScheme().toString().compareTo("content") == 0) {
            Cursor cursor = getApplicationContext().getContentResolver().query(uri, null, null, null, null);
            if (cursor.moveToFirst()) {
                int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                filePathUri = Uri.parse(cursor.getString(column_index));
            }
        }
        return filePathUri;
    }

    private void uploadFile(Uri fileUri, String firstName, String lastName, String phoneNumber, String email, boolean subscribed) {
        // create upload service client
        FileUploadInterface service = retrofit.create(FileUploadInterface.class);
        Uri filePath = getFilePathByUri(fileUri);
        File file = new File(filePath.getPath());
        // use the FileUtils to get the actual file by uri
//        File file = FileUtils.getFile(this, fileUri);

        // create RequestBody instance from file
        RequestBody requestFile =
                RequestBody.create(MediaType.parse("multipart/form-data"), file);

        // MultipartBody.Part is used to send also the actual file name
        MultipartBody.Part body =
                MultipartBody.Part.createFormData("picture", file.getName(), requestFile);

        // add another part within the multipart request
        String descriptionString = "hello, this is description speaking";
        RequestBody description =
                RequestBody.create(
                        MediaType.parse("multipart/form-data"), descriptionString);

        // finally, execute the request
        Call<ResponseBody> call = service.upload(description, firstName, lastName, phoneNumber, email, body, subscribed);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call,
                                   Response<ResponseBody> response) {
                Log.v("Upload", "success");
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e("Upload error:", t.getMessage());
            }
        });
    }

    public void addCannedREsponse(View view) {
        e5 = (EditText) cannedResponses.findViewById(R.id.editText8);
        shortName = e5.getText().toString();
        e6 = (EditText) cannedResponses.findViewById(R.id.editText10);
        message = e6.getText().toString();
        aSwitch2 = (Switch) cannedResponses.findViewById(R.id.switch2);
        if (aSwitch2.isChecked()) {
            shared = true;
        }
        CannedResponses cannedResponse = new CannedResponses(shortName, shared, message);

        FileUploadInterface fileUploadInterface = retrofit.create(FileUploadInterface.class);

        Call<CannedResponses> call = fileUploadInterface.addCannedResponse(cannedResponse);
        call.enqueue(new Callback<CannedResponses>() {
            @Override
            public void onResponse(Call<CannedResponses> call, Response<CannedResponses> response) {
                Toast.makeText(getApplicationContext(), "success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<CannedResponses> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "fail", Toast.LENGTH_SHORT).show();
            }
        });

        cannedResponses.dismiss();

    }

    public void addAwayMessages(View v) {
        aSwitch3 = (Switch) awayMessages.findViewById(R.id.switch4);
        if (aSwitch3.isChecked()) {
            status = true;
        }
        awaymessagetext = (EditText) awayMessages.findViewById(R.id.editText11);
        msg = awaymessagetext.getText().toString();
        s1 = spinner1.getSelectedItem().toString();
        s2 = spinner2.getSelectedItem().toString();
        s3 = spinner3.getSelectedItem().toString();
        s4 = spinner4.getSelectedItem().toString();
        s5 = spinner5.getSelectedItem().toString();
        s6 = spinner6.getSelectedItem().toString();
        s7 = spinner7.getSelectedItem().toString();
        s8 = spinner8.getSelectedItem().toString();
        s9 = spinner9.getSelectedItem().toString();
        s10 = spinner10.getSelectedItem().toString();
        s11 = spinner11.getSelectedItem().toString();
        s12 = spinner12.getSelectedItem().toString();
        s13 = spinner13.getSelectedItem().toString();
        s14 = spinner14.getSelectedItem().toString();
        AwayMessagesClass awayMessagesClass = new AwayMessagesClass(status, msg, s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14);
        FileUploadInterface fileUploadInterface = retrofit.create(FileUploadInterface.class);
        Call<AwayMessagesClass> call = fileUploadInterface.addAwayMessage(awayMessagesClass);
        call.enqueue(new Callback<AwayMessagesClass>() {
            @Override
            public void onResponse(Call<AwayMessagesClass> call, Response<AwayMessagesClass> response) {
                Toast.makeText(getApplicationContext(), "success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<AwayMessagesClass> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "fail", Toast.LENGTH_SHORT).show();
            }
        });
        awayMessages.dismiss();
    }

//    private void showList() {
//        String[] myString = getResources().getStringArray(R.array.conversationList);
//        Gson gson = new Gson();
//        for (String e : myString) {
//            ConversationListInfoModel c;
//            ConversationListInfoModel m=new ConversationListInfoModel();
//            c = gson.fromJson(e, ConversationListInfoModel.class);
//            m.name = c.getName();m.lastMessage=c.getLastMessage();m.time=c.getTime();
//
//cinfo.add(m);
//        }
//
//        myRecyclerViewAdapter = new MyRecyclerViewAdapter(cinfo, new CallBack() {
//            @Override
//            public void onItemClick(int position) {
//
//                Intent intent=new Intent(NavigationDraw.this,ChatActivity.class);
//                startActivity(intent);
//            }
//        });
//        recyclerView.setAdapter(myRecyclerViewAdapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//    }

}