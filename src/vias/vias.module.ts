import { Module } from '@nestjs/common';
import { ViasController } from './vias.controller';
import { ViasService } from './vias.service';
import { TypeOrmModule } from '@nestjs/typeorm';
import { Via } from './entities/via.entity';

@Module({
  imports: [TypeOrmModule.forFeature([Via])],
  controllers: [ViasController],
  providers: [ViasService]
})
export class ViasModule {}
