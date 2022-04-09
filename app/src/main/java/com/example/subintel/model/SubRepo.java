package com.example.subintel.model;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class SubRepo {

    private SubDao subDao;
    private LiveData<List<Sub>> allSubs;

    public SubRepo(Application application) {
        SubDatabase db = SubDatabase.getDatabase(application);
        subDao = db.subDao();
        allSubs = subDao.getAllSubs();
    }

    public LiveData<List<Sub>> getAllSubs() {
        return allSubs;
    }

    public void insert(Sub sub) {
        new InsertAsyncTask(subDao).execute(sub);
    }

    public LiveData<List<Sub>> getSubsByName(String name) {
        return subDao.getSubByName(name);
    }

    private static class InsertAsyncTask extends AsyncTask<Sub, Void, Void> {
        private SubDao asyncTaskDao;


        InsertAsyncTask(SubDao dao) {
            asyncTaskDao = dao;
        }


        @Override
        protected Void doInBackground(final Sub... subs) {
            asyncTaskDao.insert(subs[0]);
            return null;
        }
    }

    private static class deleteAllWordsAsyncTask extends AsyncTask<Void, Void, Void> {
        private SubDao asyncTaskDao;

        deleteAllWordsAsyncTask(SubDao dao) {
            asyncTaskDao = dao;

        }
        @Override
        protected Void doInBackground(Void... voids) {
            asyncTaskDao.deleteAll();
            return null;
        }
    }
    public void deleteAll()  {
        new deleteAllWordsAsyncTask(subDao).execute();
    }
}

