import { Module } from '@nestjs/common';
import { TypeOrmModule } from '@nestjs/typeorm';

import { EscolesController } from './escoles.controller';
import { EscolesService } from './escoles.service';

import { Escola } from './entities/escola.entity';
@Module({
  imports: [TypeOrmModule.forFeature([Escola])],
  controllers: [EscolesController],
  providers: [EscolesService]
})
export class EscolesModule {}
