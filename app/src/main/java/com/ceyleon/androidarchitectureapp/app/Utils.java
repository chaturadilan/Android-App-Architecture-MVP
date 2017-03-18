/**
 * Created by Chatura Dilan Perera on 2/3/2017.
 */
package com.ceyleon.androidarchitectureapp.app;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.ceyleon.androidarchitectureapp.models.Error;

import static com.google.common.base.Preconditions.checkNotNull;

public class Utils {

    public static class ActivityUtil {

        public static void addFragmentToActivity(@NonNull FragmentManager fragmentManager,
                                                 @NonNull Fragment fragment, int frameId) {
            checkNotNull(fragmentManager);
            checkNotNull(fragment);
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.add(frameId, fragment);
            transaction.commit();
        }
    }

    public static class ErrorUtil{

        public static Error returnUnknownError(){
            Error error = new Error();
            error.setCode(4400);
            error.setMessage("Unknown Error");
            return error;
        }
    }
}
