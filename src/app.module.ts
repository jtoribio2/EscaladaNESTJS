import { Module } from '@nestjs/common';
import { AppController } from './app.controller';
import { AppService } from './app.service';
import { TypeOrmModule } from '@nestjs/typeorm';
import { ViasModule } from './vias/vias.module';
import { SectorsModule } from './sectors/sectors.module';
import { EscolesModule } from './escoles/escoles.module';
import { EscaladorsModule } from './escaladors/escaladors.module';
import { TipusViaModule } from './tipus-via/tipus-via.module';
import { VersionController } from './version/version.controller';

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
    SectorsModule,
    EscolesModule,
    EscaladorsModule,
    TipusViaModule,
  ],
  controllers: [AppController, VersionController],
  providers: [AppService],
})
export class AppModule {}
