package com.entin.data.di

import com.entin.data.repository.RepositoryImpl
import com.entin.domain.repository.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Dependency Injection for [Repository]
 */

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindsRepository(repositoryImpl: RepositoryImpl): Repository
}