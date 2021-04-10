package com.example.wilmacare.DAO;


import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.wilmacare.ui.feedPost.FeedPost;
import com.example.wilmacare.ui.feedPost.FeedPostDao;

@Database(entities = {FeedPost.class}, version = 1)
public abstract class WilmaCareDatabase extends RoomDatabase {

    private static WilmaCareDatabase instance;

    public abstract FeedPostDao feedPostDAO();

    public static synchronized WilmaCareDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    WilmaCareDatabase.class, "wilmaCare_database").fallbackToDestructiveMigration()
                    .addCallback(roomCallBack)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallBack = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateUserDbAsync(instance).execute();
        }
    };

    private static class PopulateUserDbAsync extends AsyncTask<Void, Void, Void> {

        //private UserDao userDao;
        private FeedPostDao feedPostDAO;

        private PopulateUserDbAsync(WilmaCareDatabase db) {
            feedPostDAO = db.feedPostDAO();

        }

        @Override
        protected Void doInBackground(Void... voids) {
 /*           userDao.insert(new User("AnneLindberg", "1234", "Anne Lindberg", "annelindberg@email.com", "12345678"));
            userDao.insert(new User("Jette123", "1234", "Jette Hansen", "jetteg@email.com", "87654321"));
            userDao.insert(new User("Karen12345", "1234", "Karen Hansen ", "jette@email.com", "22334455"));*/
            feedPostDAO.insert(new FeedPost("AnneLindberg", "Hej med dig"));
            feedPostDAO.insert(new FeedPost("AnneLindberg", "Viker det+"));
            feedPostDAO.insert(new FeedPost("AnneLindberg", "Hedsafdsafj "));
            feedPostDAO.insert(new FeedPost("AnneLindberg", "dsassdfsafdsafdasfdasdsafdsfHej med afdsafdsaf"));
            feedPostDAO.insert(new FeedPost("AnneLindberg", "Hefdsafj med fdsafdsafdsaf"));
            feedPostDAO.insert(new FeedPost("AnneLindberg", "Hafdsaej mdsafdsafdsafaed dig"));
            feedPostDAO.insert(new FeedPost("AnneLindberg", "Hefsafdsj mfdsafsaed dig"));

            return null;
        }
    }
}
//Todo: instead of writing the username manually, just get it to get the username of the person