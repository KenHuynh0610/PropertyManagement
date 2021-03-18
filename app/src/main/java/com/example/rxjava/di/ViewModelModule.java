package com.example.rxjava.di;

import androidx.lifecycle.ViewModel;

import com.example.rxjava.data.RetroManager;
import com.example.rxjava.ui.auth.AuthViewModel;

import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;

import javax.inject.Provider;

import dagger.MapKey;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import kotlin.annotation.Retention;
import kotlin.annotation.Target;

public class ViewModelModule {

    @MapKey
    @interface ViewModelKey {
        Class<? extends ViewModel> value();
    }
    @Provides
    ViewModelFactory viewModelFactory(Map<Class<? extends ViewModel>, Provider<ViewModel>> providerMap) {
        return new ViewModelFactory(providerMap);
    }
    @Provides
    @IntoMap
    @ViewModelKey(AuthViewModel.class)
    ViewModel provideAuthViewModel(RetroManager retroManager) {
        return new AuthViewModel(retroManager);
    }

}

