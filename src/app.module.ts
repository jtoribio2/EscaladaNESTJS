import { Module } from '@nestjs/common';
import { AppController } from './app.controller';
import { AppService } from './app.service';
import { TypeOrmModule } from '@nestjs/typeorm';
import { ViasModule } from './vias/vias.module';

@Module({
  imports: [
    TypeOrmModule.forRoot({
      type: 'mysql',
      host: 'localhost',
      port: 3306,
      username: 'admin',
      password: '1234',
      database: 'escalada',
      autoLoadEntities: true,
      synchronize: false,
    }),
    ViasModule,
  ],
  controllers: [AppController],
  providers: [AppService],
})
export class AppModule {}
