package com.example.a044_petisoin.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.a044_petisoin.database.PetisoinDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): PetisoinDatabase{
        return Room.databaseBuilder(
            context,
            PetisoinDatabase::class.java,
            "petisoin_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideAnimalDao(database: PetisoinDatabase) = database.animalDao()

    @Provides
    @Singleton
    fun provideVaccineDao(database: PetisoinDatabase) = database.vaccineDao()

    @Provides
    @Singleton
    fun provideNoteDao(database: PetisoinDatabase) = database.noteDao()
}