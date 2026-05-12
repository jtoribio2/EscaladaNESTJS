import { Module } from '@nestjs/common';

import { TypeOrmModule } from '@nestjs/typeorm';

import { EscaladorsController } from './escaladors.controller';
import { EscaladorsService } from './escaladors.service';

import { Escalador } from './entities/escalador.entity';

@Module({
  imports: [TypeOrmModule.forFeature([Escalador])],
  controllers: [EscaladorsController],
  providers: [EscaladorsService],
})
export class EscaladorsModule {}