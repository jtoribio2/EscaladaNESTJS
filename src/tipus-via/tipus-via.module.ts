import { Module } from '@nestjs/common';
import { TypeOrmModule } from '@nestjs/typeorm';

import { TipusViaService } from './tipus-via.service';
import { TipusViaController } from './tipus-via.controller';
import { TipusVia } from './entities/tipus-via.entity';

@Module({
  imports: [
    TypeOrmModule.forFeature([TipusVia])
  ],
  controllers: [TipusViaController],
  providers: [TipusViaService],
})
export class TipusViaModule {}